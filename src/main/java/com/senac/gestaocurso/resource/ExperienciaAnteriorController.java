package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.dto.ExperiencaAnteriorDto;
import com.senac.gestaocurso.models.ExperienciaAnterior;
import com.senac.gestaocurso.service.ExperienciaAnteriorService;
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
@RequestMapping("/api/experiencias")
public class ExperienciaAnteriorController extends AbstractController{
    @Autowired
    private ExperienciaAnteriorService experienciaAnteriorService;

    @Tag(name = "EXPERIENCIAS")
    @Operation(summary = "Salva novas experiencias anteriores")
    @PostMapping
    public ResponseEntity salvar(@RequestBody ExperienciaAnterior experienciaAnterior) {
        ExperienciaAnterior save = experienciaAnteriorService.salvar(experienciaAnterior);
        return ResponseEntity.created(URI.create("/api/experiencias" + experienciaAnterior.getId())).body(save);
    }

    @Tag(name = "EXPERIENCIAS")
    @Operation(summary = "Lista todas as experiencias anteriores")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ExperiencaAnteriorDto> expAnteriors = experienciaAnteriorService.buscaTodos(filter, pageable);
        return ResponseEntity.ok(expAnteriors);
    }

    @Tag(name = "EXPERIENCIAS")
    @Operation(summary = "Busca experiencia anterior por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        ExperienciaAnterior experienciaAnterior = experienciaAnteriorService.buscaPorId(id);
        return ResponseEntity.ok().body(experienciaAnterior);
    }

    @Tag(name = "EXPERIENCIAS")
    @Operation(summary = "Deleta experiencia anterior por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        experienciaAnteriorService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "EXPERIENCIAS")
    @Operation(summary = "Atualiza experiencia anterior por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody ExperienciaAnterior entity){
        ExperienciaAnterior alterado = experienciaAnteriorService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}
