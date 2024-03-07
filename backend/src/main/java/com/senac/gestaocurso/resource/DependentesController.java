package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.models.Dependentes;
import com.senac.gestaocurso.service.DependentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/dependentes")
public class DependentesController {
    @Autowired
    private DependentesService dependentesService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Dependentes dependentes){
        Dependentes save = dependentesService.salvar(dependentes);
        return ResponseEntity.created(URI.create("/dependentes/salvar" + dependentes.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll() {
        List<Dependentes> dependentes = dependentesService.buscaTodos();
        return ResponseEntity.ok(dependentes);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Dependentes dependentes = dependentesService.buscaPorId(id);
        return ResponseEntity.ok().body(dependentes);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        dependentesService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Dependentes entity){
        Dependentes alterado = dependentesService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}

