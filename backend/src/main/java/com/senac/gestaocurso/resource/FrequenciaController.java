package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.models.Frequencia;
import com.senac.gestaocurso.service.FrequenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("api/frequencia")
public class FrequenciaController {
    @Autowired
    private FrequenciaService frequenciaService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Frequencia frequencia){
        Frequencia save = frequenciaService.salvar(frequencia);
        return ResponseEntity.created(URI.create("/frequencia/salvar" + frequencia.getId())).body(save);
    }
    @GetMapping
    public  ResponseEntity findAll() {
        List<Frequencia> frequencias = frequenciaService.buscaTodos();
        return ResponseEntity.ok(frequencias);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Frequencia frequencia = frequenciaService.buscaPorId(id);
        return ResponseEntity.ok().body(frequencia);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        frequenciaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Frequencia entity){
        Frequencia alterado = frequenciaService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}





