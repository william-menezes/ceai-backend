package app.vercel.ceaiapp.controller;

import app.vercel.ceaiapp.dto.EnderecoDTO;
import app.vercel.ceaiapp.entity.Endereco;
import app.vercel.ceaiapp.mapstruct.EnderecoMapper;
import app.vercel.ceaiapp.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/enderecos")
public class EnderecoController {

    @Autowired
    public EnderecoService enderecoService;

    @Autowired
    public EnderecoMapper enderecoMapper;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> findAll() {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> save(@RequestBody @Valid EnderecoDTO endereco/*, UriComponentsBuilder uriBuilder*/) {
        /*Endereco e = enderecoMapper.enderecoDTOParaEndereco(enderecoService.save(endereco));

        URI uri = uriBuilder.path("enderecos/{id}").buildAndExpand(e.getId()).toUri();

        return ResponseEntity.created(uri).body(
                enderecoMapper.endercoParaEnderecoDTO(e));*/
        return ResponseEntity.ok(enderecoService.save(endereco));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable Long id, @RequestBody @Valid EnderecoDTO endereco) {
        return ResponseEntity.ok(enderecoService.update(id, endereco));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enderecoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
