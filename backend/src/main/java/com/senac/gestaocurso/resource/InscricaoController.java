package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.dto.InscricaoDto;
import com.senac.gestaocurso.models.domain.Inscricao;
import com.senac.gestaocurso.service.InscricaoService;
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
@RequestMapping("api/inscricoes")
public class InscricaoController extends AbstractController{
    @Autowired
    private InscricaoService inscricaoService;

    @Tag(name = "INSCRICAO")
    @Operation(summary = "Salva nova inscricao")
    @PostMapping
    public ResponseEntity salvar(@RequestBody Inscricao inscricao){
        Inscricao save = inscricaoService.salvar(inscricao);
        return ResponseEntity.created(URI.create("/api/inscricao" + inscricao.getId())).body(save);
    }

    @Tag(name = "INSCRICAO")
    @Operation(summary = "Lista todas as inscricoes")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<InscricaoDto> inscricao = inscricaoService.buscaTodos(filter, pageable);
        return ResponseEntity.ok(inscricao);
    }

    @Tag(name = "INSCRICAO")
    @Operation(summary = "Busca inscricao por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Inscricao inscricao = inscricaoService.buscaPorId(id);
        return ResponseEntity.ok().body(inscricao);
    }

    @Tag(name = "INSCRICAO")
    @Operation(summary = "Deleta inscricao por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        inscricaoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "INSCRICAO")
    @Operation(summary = "Atualiza inscricao por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Inscricao entity){
        Inscricao inscricao = inscricaoService.alterar(id, entity);
        return  ResponseEntity.ok().body(inscricao);
    }
}
