package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.models.ExpAnterior;
import com.senac.gestaocurso.service.ExpAnteriorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;


@RestController
public class ExpAnteriorController {
    @Autowired
    private ExpAnteriorService expAnteriorService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody ExpAnterior expAnterior) {
        ExpAnterior save = expAnteriorService.salvar(expAnterior);
        return ResponseEntity.created(URI.create("/funcionario/salvar" + expAnterior.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll() {
        List<ExpAnterior> expAnteriors = expAnteriorService.buscaTodos();
        return ResponseEntity.ok(expAnteriors);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        ExpAnterior expAnterior = expAnteriorService.buscaPorId(id);
        return ResponseEntity.ok().body(expAnterior);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        expAnteriorService.remover(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody ExpAnterior entity){
        ExpAnterior alterado = expAnteriorService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}




