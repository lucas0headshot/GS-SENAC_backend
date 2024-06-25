package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.dto.AulaDto;
import com.senac.gestaocurso.models.domain.Aula;
import com.senac.gestaocurso.service.AulaService;
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
@RequestMapping("/api/aulas")
public class AulaController extends AbstractController{


    @Autowired
    private AulaService aulaService;

    @Tag(name = "AULAS")
    @Operation(summary = "Salvar novas aulas")
    @PostMapping()
    public ResponseEntity salvar(@RequestBody Aula aulas){
        Aula save = aulaService.salvar(aulas);
        return ResponseEntity.created(URI.create("/api/aulas" + aulas.getId())).body(save);
    }


    @Tag(name = "AULAS")
    @Operation(summary = "Lista todas as aulas")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AulaDto> aulas = aulaService.buscaTodos(filter, pageable);
        return ResponseEntity.ok(aulas);
    }
    @Tag(name = "AULAS")
    @Operation(summary = "Busca aulas por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Aula aulas = aulaService.buscaPorId(id);
        return ResponseEntity.ok().body(aulas);
    }

    @Tag(name = "AULAS")
    @Operation(summary = "Deleta aulas por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        aulaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "AULAS")
    @Operation(summary = "Atualiza aulas existentes por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Aula entity){
        Aula alterado = aulaService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}

