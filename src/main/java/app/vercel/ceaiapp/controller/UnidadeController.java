package app.vercel.ceaiapp.controller;

import app.vercel.ceaiapp.dto.UnidadeDTO;
import app.vercel.ceaiapp.entity.Unidade;
import app.vercel.ceaiapp.service.UnidadeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/unidades")
public class UnidadeController {

    /*@Autowired
    public UnidadeService unidadeService;

    @GetMapping
    public ResponseEntity<Page<UnidadeDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(unidadeService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<UnidadeDTO> save(@RequestBody @Valid UnidadeDTO unidadeDTO, UriComponentsBuilder uriBuilder) {
        UnidadeDTO unidade = unidadeService.save(unidadeDTO);

        URI uri = uriBuilder.path("/unidades/{id}").buildAndExpand(unidade.getId()).toUri();

        return ResponseEntity.created(uri).body(unidade);
    }

    @PostMapping(path = "{id}/coordenador")
    public ResponseEntity<UnidadeDTO> setCoordenador(@PathVariable Long id, @RequestBody Long idCoordenador) {
        return ResponseEntity.ok(unidadeService.setCoordenador(id, idCoordenador));*/
    }

