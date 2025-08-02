package app.vercel.ceaiapp.service;

import app.vercel.ceaiapp.dto.EnderecoDTO;
import app.vercel.ceaiapp.dto.FuncionarioDTO;
import app.vercel.ceaiapp.dto.FuncionarioResumoDTO;
import app.vercel.ceaiapp.entity.Funcionario;
import app.vercel.ceaiapp.repository.FuncionarioRepository;
import app.vercel.ceaiapp.service.exception.DatabaseException;
import app.vercel.ceaiapp.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Transactional(readOnly = true)
    public Page<FuncionarioResumoDTO> findAll(Pageable pageable) {
        Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
        return funcionarios.map(FuncionarioResumoDTO::new);
    }

    @Transactional(readOnly = true)
    public FuncionarioDTO findById(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
        return funcionarioDTO;
    }

    @Transactional(readOnly = true)
    public List<FuncionarioResumoDTO> findByNome(String nome) {
        List<Funcionario> funcionarios = funcionarioRepository.findByPessoaNomeContainingIgnoreCase(nome);
        List<FuncionarioResumoDTO> funcionariosResumoDTO = funcionarios.stream().map(FuncionarioResumoDTO::new).toList();
        return funcionariosResumoDTO;
    }

    @Transactional
    public FuncionarioDTO save(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario(funcionarioDTO);
        funcionario = funcionarioRepository.save(funcionario);

        return new FuncionarioDTO(funcionario);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete (Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Funcionário não encontrado");
        }

        try {
            funcionarioRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    @Transactional
    public FuncionarioDTO update(Long id, FuncionarioDTO funcionarioDTO) {
        try {
            Funcionario funcionario = funcionarioRepository.getReferenceById(id);
            copyData(funcionarioDTO, funcionario);
            funcionario = funcionarioRepository.save(funcionario);
            return new FuncionarioDTO(funcionario);

        } catch (EntityNotFoundException f) {
            throw new ResourceNotFoundException("Funcionário não encontrado");
        }
    }

    private void copyData(FuncionarioDTO funcionarioDTO, Funcionario funcionario) {
        funcionario.getPessoa().setNome(funcionarioDTO.getNome());
        funcionario.getPessoa().setSexo(funcionarioDTO.getSexo());
        funcionario.getPessoa().setDataNascimento(funcionarioDTO.getDataNascimento());
        funcionario.getPessoa().setWhatsapp(funcionarioDTO.getWhatsapp());
        funcionario.getPessoa().setTelefone(funcionarioDTO.getTelefone());
        funcionario.getPessoa().setRg(funcionarioDTO.getRg());
        funcionario.getPessoa().setOrgaoExpedidor(funcionarioDTO.getOrgaoExpedidor());
        funcionario.getPessoa().setDataExpedicao(funcionarioDTO.getDataExpedicao());
        funcionario.getPessoa().setCpf(funcionarioDTO.getCpf());
        funcionario.getPessoa().setMae(funcionarioDTO.getMae());
        funcionario.getPessoa().setNaturalidade(funcionarioDTO.getNaturalidade());

        EnderecoDTO e = new EnderecoDTO(
                funcionarioDTO.getEndereco().getLogradouro(),
                funcionarioDTO.getEndereco().getNumero(),
                funcionarioDTO.getEndereco().getComplemento(),
                funcionarioDTO.getEndereco().getCep(),
                funcionarioDTO.getEndereco().getBairro());

        enderecoService.update(funcionario.getPessoa().getEndereco().getId(), e);

        funcionario.setMatricula(funcionarioDTO.getMatricula());
        funcionario.setEscolaridade(funcionarioDTO.getEscolaridade());
        funcionario.setCargo(funcionarioDTO.getCargo());
        funcionario.setFuncao(funcionarioDTO.getFuncao());
        funcionario.setVinculo(funcionarioDTO.getVinculo());
        funcionario.setEmpresa(funcionarioDTO.getEmpresa());
        funcionario.setDataAdmissao(funcionarioDTO.getDataAdmissao());
        funcionario.setCargaHoraria(funcionarioDTO.getCargaHoraria());
        funcionario.setDataAtualizacao(Instant.now());
    }
}
