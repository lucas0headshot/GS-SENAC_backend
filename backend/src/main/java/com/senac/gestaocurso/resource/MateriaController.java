package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.dto.MateriaDto;
import com.senac.gestaocurso.models.domain.Materia;
import com.senac.gestaocurso.service.MateriaService;
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
@RequestMapping("api/materia")
public class MateriaController extends AbstractController{
    @Autowired
    private MateriaService materiaService;

    @Tag(name = "MATERIA")
    @Operation(summary = "Salva nova materia")
    @PostMapping
    public ResponseEntity salvar(@RequestBody Materia materia){
        Materia save = materiaService.salvar(materia);
        return ResponseEntity.created(URI.create("/api/materia" + materia.getId())).body(save);
    }

    @Tag(name = "MATERIA")
    @Operation(summary = "Lista todas as materias")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MateriaDto> materias = materiaService.buscaTodos(filter, pageable);
        return ResponseEntity.ok(materias);
    }

    @Tag(name = "MATERIA")
    @Operation(summary = "Busca materia por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Materia materia = materiaService.buscaPorId(id);
        return ResponseEntity.ok().body(materia);
    }

    @Tag(name = "MATERIA")
    @Operation(summary = "Deleta materia por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        materiaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "MATERIA")
    @Operation(summary = "Atualiza materia por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Materia entity){
        Materia alterado = materiaService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}
