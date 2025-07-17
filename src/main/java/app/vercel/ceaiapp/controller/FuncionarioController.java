package app.vercel.ceaiapp.controller;

import app.vercel.ceaiapp.dto.FuncionarioDTO;
import app.vercel.ceaiapp.dto.FuncionarioResumoDTO;
import app.vercel.ceaiapp.entity.Funcionario;
import app.vercel.ceaiapp.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/funcionario")
public class FuncionarioController {

    @Autowired
    public FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<Page<FuncionarioResumoDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(funcionarioService.findAll(pageable));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.findById(id));
    }

    @GetMapping(path = "/procurar")
    public ResponseEntity<List<FuncionarioResumoDTO>> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(funcionarioService.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> save(@RequestBody @Valid FuncionarioDTO funcionarioDTO, UriComponentsBuilder uriBuilder) {

        FuncionarioDTO fDTO = funcionarioService.save(funcionarioDTO);;

        URI uri = uriBuilder.path("/funcionario/{id}").buildAndExpand(fDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(fDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @RequestBody @Valid FuncionarioDTO funcionario) {
        return ResponseEntity.ok(funcionarioService.update(id, funcionario));
    }
}
