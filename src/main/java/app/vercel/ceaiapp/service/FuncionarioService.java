package app.vercel.ceaiapp.service;

import app.vercel.ceaiapp.dto.FuncionarioDTO;
import app.vercel.ceaiapp.dto.FuncionarioResumoDTO;
import app.vercel.ceaiapp.entity.Funcionario;
import app.vercel.ceaiapp.repository.FuncionarioRepository;
import app.vercel.ceaiapp.service.exception.DatabaseException;
import app.vercel.ceaiapp.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Transactional(readOnly = true)
    public List<FuncionarioResumoDTO> findAll() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        List<FuncionarioResumoDTO> funcionariosDTO = funcionarios.stream().map(FuncionarioResumoDTO::new).toList();
        return funcionariosDTO;

    }

    @Transactional(readOnly = true)
    public FuncionarioDTO findById(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
        return funcionarioDTO;
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
}
