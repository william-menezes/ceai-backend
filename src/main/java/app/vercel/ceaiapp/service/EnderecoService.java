package app.vercel.ceaiapp.service;

import app.vercel.ceaiapp.dto.EnderecoDTO;
import app.vercel.ceaiapp.entity.Endereco;
import app.vercel.ceaiapp.repository.EnderecoRepository;
import app.vercel.ceaiapp.service.exception.DatabaseException;
import app.vercel.ceaiapp.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Endereco findById(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado"));
    }

    @Transactional
    public Endereco save(Endereco e) {
        return enderecoRepository.save(e);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {

        if(!enderecoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Endereco não encontrado");
        }

        try {
            enderecoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }


    }

    @Transactional
    public Endereco update(Long id, EnderecoDTO endereco) {
        try {
            Endereco e = enderecoRepository.getReferenceById(id);
            copyData(endereco, e);
            e = enderecoRepository.save(e);
            return e;

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Endereco não encontrado");
        }
    }

    private void copyData(EnderecoDTO enderecoDTO, Endereco endereco) {
        endereco.setLogradouro(enderecoDTO.logradouro());
        endereco.setNumero(enderecoDTO.numero());
        endereco.setComplemento(enderecoDTO.complemento());
        endereco.setCep(enderecoDTO.cep());
        endereco.setBairro(enderecoDTO.bairro());
    }

}
