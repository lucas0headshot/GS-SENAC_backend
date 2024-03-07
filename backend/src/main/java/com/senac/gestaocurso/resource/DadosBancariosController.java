package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.models.DadosBancarios;
import com.senac.gestaocurso.service.DadosBancariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("api/dadosbancarios")
public class DadosBancariosController {
    @Autowired
    private DadosBancariosService dadosBancariosService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody DadosBancarios dadosBancarios){
        DadosBancarios save = dadosBancariosService.salvar(dadosBancarios);
        return ResponseEntity.created(URI.create("/dadosbancarios/salvar" + dadosBancarios.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll() {
        List<DadosBancarios> dadosBancarios = dadosBancariosService.buscaTodos();
        return ResponseEntity.ok(dadosBancarios);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        DadosBancarios dadosBancarios = dadosBancariosService.buscaPorId(id);
        return ResponseEntity.ok().body(dadosBancarios);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        dadosBancariosService.remover(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody DadosBancarios entity){
        DadosBancarios alterado = dadosBancariosService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}

