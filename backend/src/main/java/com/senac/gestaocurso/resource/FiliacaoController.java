package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.models.Filiacao;
import com.senac.gestaocurso.service.FiliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("api/filiacao")
public class FiliacaoController extends AbstractController {
    @Autowired
    private FiliacaoService filiacaoService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Filiacao filiacao){
        Filiacao save = filiacaoService.salvar(filiacao);
        return ResponseEntity.created(URI.create("/api/filiacao" + filiacao.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Filiacao> filiacao = filiacaoService.buscaTodos(pageable);
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

