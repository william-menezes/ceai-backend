package app.vercel.ceaiapp.service;

import app.vercel.ceaiapp.dto.EnderecoDTO;
import app.vercel.ceaiapp.dto.FuncionarioDTO;
import app.vercel.ceaiapp.dto.FuncionarioResumoDTO;
import app.vercel.ceaiapp.entity.Funcionario;
import app.vercel.ceaiapp.mapstruct.EnderecoMapper;
import app.vercel.ceaiapp.mapstruct.FuncionarioMapper;
import app.vercel.ceaiapp.repository.FuncionarioRepository;
import app.vercel.ceaiapp.service.exception.DatabaseException;
import app.vercel.ceaiapp.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private FuncionarioMapper funcionarioMapper;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Autowired
    private EnderecoService enderecoService;

    @Transactional(readOnly = true)
    public Page<FuncionarioResumoDTO> findAll(Pageable pageable) {
        Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
        return funcionarios.map(f -> funcionarioMapper.funcionarioParaFuncionarioResumoDTO(f));
    }

    @Transactional(readOnly = true)
    public FuncionarioDTO findById(Long id) {
        return funcionarioMapper.funcionarioParaFuncionarioDTO(
                funcionarioRepository.findById(id).
                        orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado")));
    }


    @Transactional(readOnly = true)
    public Page<FuncionarioResumoDTO> findByNome(String nome, int pagina, int tamanho) {
        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.Direction.ASC, "pessoa.nome");

        if (nome != null && !nome.isEmpty()) {
            Page<Funcionario> funcionarios = funcionarioRepository.findByPessoaNomeContainingIgnoreCase(nome, pageable);
            return funcionarios.map(f -> funcionarioMapper.funcionarioParaFuncionarioResumoDTO(f));
        }

        Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
        return funcionarios.map(f -> funcionarioMapper.funcionarioParaFuncionarioResumoDTO(f));

    }

    @Transactional
    public FuncionarioDTO save(FuncionarioDTO funcionarioDTO) {
        return funcionarioMapper.funcionarioParaFuncionarioDTO(
                funcionarioRepository.save(
                        funcionarioMapper.funcionarioDTOParaFuncionario(funcionarioDTO)));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
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
            return funcionarioMapper.funcionarioParaFuncionarioDTO(funcionario);

        } catch (EntityNotFoundException f) {
            throw new ResourceNotFoundException("Funcionário não encontrado");
        }
    }

    private void copyData(FuncionarioDTO funcionarioDTO, Funcionario funcionario) {
        funcionario.getPessoa().setNome(funcionarioDTO.nome());
        funcionario.getPessoa().setSexo(funcionarioDTO.sexo());
        funcionario.getPessoa().setDataNascimento(funcionarioDTO.dataNascimento());
        funcionario.getPessoa().setWhatsapp(funcionarioDTO.whatsapp());
        funcionario.getPessoa().setTelefone(funcionarioDTO.telefone());
        funcionario.getPessoa().setRg(funcionarioDTO.rg());
        funcionario.getPessoa().setOrgaoExpedidor(funcionarioDTO.orgaoExpedidor());
        funcionario.getPessoa().setDataExpedicao(funcionarioDTO.dataExpedicao());
        funcionario.getPessoa().setCpf(funcionarioDTO.cpf());
        funcionario.getPessoa().setMae(funcionarioDTO.mae());
        funcionario.getPessoa().setNaturalidade(funcionarioDTO.naturalidade());

        EnderecoDTO enderecoDTO = new EnderecoDTO(
                funcionarioDTO.endereco().getLogradouro(),
                funcionarioDTO.endereco().getNumero(),
                funcionarioDTO.endereco().getComplemento(),
                funcionarioDTO.endereco().getCep(),
                funcionarioDTO.endereco().getBairro());

        if (funcionario.getPessoa().getEndereco() == null) {
            funcionario.getPessoa().setEndereco(enderecoMapper.enderecoDTOParaEndereco(enderecoDTO));
        } else {
            enderecoService.update(funcionario.getPessoa().getEndereco().getId(), enderecoDTO);
        }

        funcionario.setMatricula(funcionarioDTO.matricula());
        funcionario.setEscolaridade(funcionarioDTO.escolaridade());
        funcionario.setCargo(funcionarioDTO.cargo());
        funcionario.setFuncao(funcionarioDTO.funcao());
        funcionario.setVinculo(funcionarioDTO.vinculo());
        funcionario.setEmpresa(funcionarioDTO.empresa());
        funcionario.setDataAdmissao(funcionarioDTO.dataAdmissao());
        funcionario.setCargaHoraria(funcionarioDTO.cargaHoraria());
        funcionario.setDataAtualizacao(Instant.now());
    }
}
