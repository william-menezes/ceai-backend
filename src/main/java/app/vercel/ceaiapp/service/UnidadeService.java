package app.vercel.ceaiapp.service;

import app.vercel.ceaiapp.dto.FuncionarioDTO;
import app.vercel.ceaiapp.dto.UnidadeDTO;
import app.vercel.ceaiapp.entity.Funcionario;
import app.vercel.ceaiapp.entity.Unidade;
import app.vercel.ceaiapp.repository.UnidadeRepository;
import app.vercel.ceaiapp.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UnidadeService {

    /*@Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    @Transactional(readOnly = true)
    public Page<UnidadeDTO> findAll(Pageable pageable) {
        Page<Unidade> unidades = unidadeRepository.findAll(pageable);
        return unidades.map(UnidadeDTO::new);
    }

    @Transactional(readOnly = true)
    public UnidadeDTO findById(Long id) {
        Unidade unidade = unidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unidade não encontrada"));
        UnidadeDTO unidadeDTO = new UnidadeDTO(unidade);
        return unidadeDTO;
    }

    @Transactional
    public UnidadeDTO save(UnidadeDTO unidadeDTO) {
        Unidade unidade = new Unidade(unidadeDTO);

        unidade = unidadeRepository.save(unidade);

        return new UnidadeDTO(unidade);
    }

    @Transactional
    public UnidadeDTO setCoordenador(Long idUnidade, Long idCoordenador) {
        UnidadeDTO unidadeDTO = this.findById(idUnidade);

        FuncionarioDTO coordenadorDTO = funcionarioService.findById(idCoordenador);
        //Funcionario coordenador = new Funcionario(coordenadorDTO);

        Unidade unidade = new Unidade(unidadeDTO);
        unidade.setCoordenador(new Funcionario(coordenadorDTO));

        return new UnidadeDTO(unidade);
    }*/

}
