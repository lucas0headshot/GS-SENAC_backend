package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.models.domain.Certificacao;
import com.senac.gestaocurso.service.CertificacoesService;
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
@RequestMapping("/api/certificacoes")
public class CertificacoesController extends AbstractController{

    @Autowired
    private CertificacoesService certificacoesService;

    @Tag(name = "CERTIFICACOES")
    @Operation(summary = "Salvar novas certificacoes")
    @PostMapping
    public ResponseEntity salvar(@RequestBody Certificacao certificacao) {
        Certificacao save = certificacoesService.salvar(certificacao);
        return ResponseEntity.created(URI.create("/api/certificacoes" + certificacao.getId())).body(save);
    }

    @Tag(name = "CERTIFICACOES")
    @Operation(summary = "Listar todas as certificacoes")
    @GetMapping
    public ResponseEntity findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Certificacao> certificacoes = certificacoesService.buscaTodos(pageable);
        return ResponseEntity.ok(certificacoes);
    }

    @Tag(name = "CERTIFICACOES")
    @Operation(summary = "Busca certificacoes por ID")
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Certificacao certificacao = certificacoesService.buscaPorId(id);
        return ResponseEntity.ok().body(certificacao);
    }

    @Tag(name = "CERTIFICACOES")
    @Operation(summary = "Deleta certificacoes por ID")
    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        certificacoesService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "CERTIFICACOES")
    @Operation(summary = "Atualiza certificacoes por ID")
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Certificacao entity) {
        Certificacao alterado = certificacoesService.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}

