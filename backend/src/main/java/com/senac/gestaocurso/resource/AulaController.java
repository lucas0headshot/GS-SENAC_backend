package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.models.Aula;
import com.senac.gestaocurso.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/aulas")
public class AulaController {
    @Autowired
    private AulaService aulaService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Aula aulas){
        Aula save = aulaService.salvar(aulas);
        return ResponseEntity.created(URI.create("/api/aulas" + aulas.getId())).body(save);
    }


    @GetMapping
    public  ResponseEntity findAll(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "0") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Aula> aulas = aulaService.buscaTodos(pageable);
        return ResponseEntity.ok(aulas);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Aula aulas = aulaService.buscaPorId(id);
        return ResponseEntity.ok().body(aulas);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        aulaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Aula entity){
        Aula alterado = aulaService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}

