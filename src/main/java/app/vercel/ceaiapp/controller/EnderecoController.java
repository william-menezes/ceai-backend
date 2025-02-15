package app.vercel.ceaiapp.controller;

import app.vercel.ceaiapp.dto.EnderecoDTO;
import app.vercel.ceaiapp.entity.Endereco;
import app.vercel.ceaiapp.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/endereco")
public class EnderecoController {

    @Autowired
    public EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id) {
        Endereco endereco = enderecoService.findById(id);

        return ResponseEntity.ok(enderecoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody @Valid Endereco endereco, UriComponentsBuilder uriBuilder) {
        Endereco e = enderecoService.save(endereco);

        URI uri = uriBuilder.path("endereco/{id}").buildAndExpand(e.getId()).toUri();

        return ResponseEntity.created(uri).body(e);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody @Valid EnderecoDTO endereco) {
        return ResponseEntity.ok(enderecoService.update(id, endereco));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enderecoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
