package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.dto.AvaliacaoDto;
import com.senac.gestaocurso.models.domain.Avaliacao;
import com.senac.gestaocurso.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController extends AbstractController {
    @Autowired
    private AvaliacaoService avaliacaoService;

    @Tag(name = "AVALIACAO")
    @Operation(summary = "Salvar novas avaliacoes")
    @PostMapping()
    public ResponseEntity salvar(@RequestBody Avaliacao avaliacoes) {
        Avaliacao save = avaliacaoService.salvar(avaliacoes);
        return ResponseEntity.created(URI.create("/api/avaliacao" + avaliacoes.getId())).body(save);
    }

    @Tag(name = "AVALIACAO")
    @Operation(summary = "Lista todas avaliacoes")
    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AvaliacaoDto> avaliacoes = avaliacaoService.buscaTodos(filter,pageable);
        return ResponseEntity.ok(avaliacoes);
    }

    @Tag(name = "AVALIACAO")
    @Operation(summary = "Busca avaliacoes por ID")
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Avaliacao avaliacao = avaliacaoService.buscaPorId(id);
        return ResponseEntity.ok().body(avaliacao);
    }

    @Tag(name = "AVALIACAO")
    @Operation(summary = "Deleta avaliacoes por ID")
    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        avaliacaoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
