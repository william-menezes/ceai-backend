package app.vercel.ceaiapp.controller;

import app.vercel.ceaiapp.dto.FuncionarioDTO;
import app.vercel.ceaiapp.dto.FuncionarioResumoDTO;
import app.vercel.ceaiapp.entity.Funcionario;
import app.vercel.ceaiapp.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<FuncionarioResumoDTO>> findAll() {
        return ResponseEntity.ok(funcionarioService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> save(@RequestBody @Valid FuncionarioDTO funcionarioDTO, UriComponentsBuilder uriBuilder) {


        FuncionarioDTO fDTO = funcionarioService.save(funcionarioDTO);;

        URI uri = uriBuilder.path("/funcionario/{id}").buildAndExpand(fDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(fDTO);
    }
}
