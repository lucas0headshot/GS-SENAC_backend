package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.models.domain.Turma;
import com.senac.gestaocurso.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Turma turma){
        Turma save = turmaService.salvar(turma);
        return ResponseEntity.created(URI.create("/api/turma" + turma.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Turma> funcionarios = turmaService.buscaTodos(pageable);
        return ResponseEntity.ok(funcionarios);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Turma funcionario = turmaService.buscaPorId(id);
        return ResponseEntity.ok().body(funcionario);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        turmaService.remover(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Turma entity){
        Turma alterado = turmaService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}


