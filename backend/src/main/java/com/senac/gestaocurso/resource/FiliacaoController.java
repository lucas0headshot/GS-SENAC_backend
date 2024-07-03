package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.dto.FiliacaoDto;
import com.senac.gestaocurso.models.Filiacao;
import com.senac.gestaocurso.service.FiliacaoService;
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
@RequestMapping("api/filiacao")
public class FiliacaoController extends AbstractController{
    @Autowired
    private FiliacaoService filiacaoService;

    @Tag(name = "FILIACAO")
    @Operation(summary = "Salva novas filiacoes")
    @PostMapping()
    public ResponseEntity salvar(@RequestBody Filiacao filiacao){
        Filiacao save = filiacaoService.salvar(filiacao);
        return ResponseEntity.created(URI.create("/api/filiacao" + filiacao.getId())).body(save);
    }

    @Tag(name = "FILIACAO")
    @Operation(summary = "Lista todas as filiacoes")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FiliacaoDto> filiacao = filiacaoService.buscaTodos(filter, pageable);
        return ResponseEntity.ok(filiacao);
    }

    @Tag(name = "FILIACAO")
    @Operation(summary = "Busca filiacao por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Filiacao filiacao = filiacaoService.buscaPorId(id);
        return ResponseEntity.ok().body(filiacao);
    }

    @Tag(name = "FILIACAO")
    @Operation(summary = "Deleta filiacao por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        filiacaoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "FILIACAO")
    @Operation(summary = "Atualiza filiacao por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Filiacao entity){
        Filiacao alterado = filiacaoService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}
