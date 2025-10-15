package app.vercel.ceaiapp.controller;

import app.vercel.ceaiapp.dto.FuncionarioDTO;
import app.vercel.ceaiapp.dto.FuncionarioResumoDTO;
import app.vercel.ceaiapp.mapstruct.FuncionarioMapper;
import app.vercel.ceaiapp.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/funcionarios")
public class FuncionarioController {

    @Autowired
    public FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioMapper funcionarioMapper;

    @GetMapping
    public ResponseEntity<Page<FuncionarioResumoDTO>> findByNome(@RequestParam String nome, @RequestParam int pagina, @RequestParam int tamanho) {
        return ResponseEntity.ok(funcionarioService.findByNome(nome, pagina, tamanho));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> save(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {
        /*FuncionarioDTO fDTO = funcionarioService.save(funcionarioDTO);
        URI uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(fDTO.getId()).toUri();*/

        return ResponseEntity.ok(funcionarioService.save(funcionarioDTO));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @RequestBody @Valid FuncionarioDTO funcionario) {
        return ResponseEntity.ok(funcionarioService.update(id, funcionario));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        funcionarioService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
