package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.models.ExperienciaAnterior;
import com.senac.gestaocurso.service.ExperienciaAnteriorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;


@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaAnteriorController {
    @Autowired
    private ExperienciaAnteriorService experienciaAnteriorService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody ExperienciaAnterior experienciaAnterior) {
        ExperienciaAnterior save = experienciaAnteriorService.salvar(experienciaAnterior);
        return ResponseEntity.created(URI.create("/api/experiencias" + experienciaAnterior.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ExperienciaAnterior> expAnteriors = experienciaAnteriorService.buscaTodos(pageable);
        return ResponseEntity.ok(expAnteriors);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        ExperienciaAnterior experienciaAnterior = experienciaAnteriorService.buscaPorId(id);
        return ResponseEntity.ok().body(experienciaAnterior);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        experienciaAnteriorService.remover(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody ExperienciaAnterior entity){
        ExperienciaAnterior alterado = experienciaAnteriorService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}




