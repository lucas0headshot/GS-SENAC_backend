package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.models.Materia;
import com.senac.gestaocurso.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/materia")
public class MateriaController extends AbstractController {
    @Autowired
    private MateriaService materiaService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Materia materia){
        Materia save = materiaService.salvar(materia);
        return ResponseEntity.created(URI.create("/api/materia" + materia.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Materia> materias = materiaService.buscaTodos(pageable);
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


