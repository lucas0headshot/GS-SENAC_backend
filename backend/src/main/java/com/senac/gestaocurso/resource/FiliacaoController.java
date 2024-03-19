package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.models.Filiacao;
import com.senac.gestaocurso.service.FiliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("api/filiacao")
public class FiliacaoController {
    @Autowired
    private FiliacaoService filiacaoService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Filiacao filiacao){
        Filiacao save = filiacaoService.salvar(filiacao);
        return ResponseEntity.created(URI.create("/filiacao/salvar" + filiacao.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll() {
        List<Filiacao> filiacao = filiacaoService.buscaTodos();
        return ResponseEntity.ok(filiacao);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Filiacao filiacao = filiacaoService.buscaPorId(id);
        return ResponseEntity.ok().body(filiacao);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        filiacaoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Filiacao entity){
        Filiacao alterado = filiacaoService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}

