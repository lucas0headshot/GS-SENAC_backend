package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.models.domain.Curso;
import com.senac.gestaocurso.service.CursoService;
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
@RequestMapping("/api/cursos")
public class CursoController extends AbstractController{
    @Autowired
    private CursoService cursoService;

    @Tag(name = "CURSOS")
    @Operation(summary = "Salvar novas cursos")
    @PostMapping()
    public ResponseEntity salvar(@RequestBody Curso curso){
        Curso save = cursoService.salvar(curso);
        return ResponseEntity.created(URI.create("/api/cursos" + curso.getId())).body(save);
    }

    @Tag(name = "CURSOS")
    @Operation(summary = "Lista todos os cursos")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Curso> cursos = cursoService.buscaTodos(pageable);
        return ResponseEntity.ok(cursos);
    }

    @Tag(name = "CURSOS")
    @Operation(summary = "Busca curso por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Curso curso = cursoService.buscaPorId(id);
        return ResponseEntity.ok().body(curso);
    }

    @Tag(name = "CURSOS")
    @Operation(summary = "Deleta curso por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        cursoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "CURSOS")
    @Operation(summary = "Atualiza curso por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Curso entity){
        Curso alterado = cursoService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}





