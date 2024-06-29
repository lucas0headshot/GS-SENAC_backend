package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.models.Chamada;
import com.senac.gestaocurso.service.ChamadaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/chamada")
public class ChamadaController extends AbstractController {
    @Autowired
    private ChamadaService service;

    @Tag(name = "CHAMADA")
    @Operation(summary = "Salvar novas chamadas")
    @PostMapping
    public ResponseEntity salvar(@RequestBody Chamada chamada) {
        return ResponseEntity.ok(service.salvar(chamada));
    }

    @Tag(name = "CHAMADA")
    @Operation(summary = "Lista todas as chamadas")
    @GetMapping
    public ResponseEntity buscaTodos(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Chamada> chamadas = service.buscaTodos(pageable);
        return ResponseEntity.ok(chamadas);
    }

    @Tag(name = "CHAMADA")
    @Operation(summary = "Busca chamada por ID")
    @GetMapping("/{id}")
    public ResponseEntity buscaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.buscaPorId(id));
    }

    @Tag(name = "CHAMADA")
    @Operation(summary = "Atualiza chamadas por ID")
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestParam("id") Long id, @RequestBody Chamada chamada) {
        return ResponseEntity.ok().body(service.alterar(id, chamada));
    }

    @Tag(name = "CHAMADA")
    @Operation(summary = "Deleta chamadas por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity remover(@RequestParam("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
