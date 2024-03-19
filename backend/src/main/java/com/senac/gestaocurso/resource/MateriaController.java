package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.models.Materia;
import com.senac.gestaocurso.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/materia")
public class MateriaController {
    @Autowired
    private MateriaService materiaService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Materia materia){
        Materia save = materiaService.salvar(materia);
        return ResponseEntity.created(URI.create("/materia/salvar" + materia.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll() {
        List<Materia> materias = materiaService.buscaTodos();
        return ResponseEntity.ok(materias);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Materia materia = materiaService.buscaPorId(id);
        return ResponseEntity.ok().body(materia);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        materiaService.remover(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Materia entity){
        Materia alterado = materiaService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}


