package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.models.Certificacao;
import com.senac.gestaocurso.service.CertificacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController
@RequestMapping("/api/certificacoes")
public class CertificacoesController {

        @Autowired
        private CertificacoesService certificacoesService;

        @PostMapping()
        public ResponseEntity salvar(@RequestBody Certificacao certificacao){
            Certificacao save = certificacoesService.salvar(certificacao);
            return ResponseEntity.created(URI.create("/api/certificacoes" + certificacao.getId())).body(save);
        }

        @GetMapping
        public  ResponseEntity findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
            Pageable pageable = PageRequest.of(page, size);
            Page<Certificacao> certificacoes = certificacoesService.buscaTodos(pageable);
            return ResponseEntity.ok(certificacoes);
        }
        @GetMapping("/{id}")
        public  ResponseEntity findById(@PathVariable("id") Long id){
            Certificacao certificacao = certificacoesService.buscaPorId(id);
            return ResponseEntity.ok().body(certificacao);
        }

        @DeleteMapping("{id}")
        public  ResponseEntity remove(@PathVariable("id") Long id){
            certificacoesService.remover(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("{id}")
        public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Certificacao entity){
            Certificacao alterado = certificacoesService.alterar(id, entity);
            return  ResponseEntity.ok().body(alterado);
        }
    }

