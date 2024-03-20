package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.models.Avaliacao;
import com.senac.gestaocurso.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController extends AbstractController {
    public class FuncionarioController {
        @Autowired
        private AvaliacaoService avaliacaoService;

        @PostMapping()
        public ResponseEntity salvar(@RequestBody Avaliacao avaliacoes) {
            Avaliacao save = avaliacaoService.salvar(avaliacoes);
            return ResponseEntity.created(URI.create("/api/avaliacao" + avaliacoes.getId())).body(save);
        }


        @GetMapping
        public ResponseEntity findAll(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "0") int size) {
            Pageable pageable = PageRequest.of(page, size);
            Page<Avaliacao> avaliacoes = avaliacaoService.buscaTodos(pageable);
            return ResponseEntity.ok(avaliacoes);
        }

        @GetMapping("/{id}")
        public ResponseEntity findById(@PathVariable("id") Long id) {
            Avaliacao avaliacao = avaliacaoService.buscaPorId(id);
            return ResponseEntity.ok().body(avaliacao);
        }


        @DeleteMapping("{id}")
        public ResponseEntity remove(@PathVariable("id") Long id) {
            avaliacaoService.remover(id);
            return ResponseEntity.noContent().build();
        }

        /**
         * Reparar classe Avaliacao para alterar o service, mapeamento esta certo
         */
       /** @PutMapping("{id}")
        public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Avaliacao entity) {
            Avaliacao avaliacao = avaliacaoService.alterar(id, entity);
        */
        }
    }

