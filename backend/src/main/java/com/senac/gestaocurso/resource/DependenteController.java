package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.dto.DependenteDto;
import com.senac.gestaocurso.models.Dependente;
import com.senac.gestaocurso.service.DependenteService;
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
@RequestMapping("api/dependentes")
public class DependenteController extends AbstractController{
    @Autowired
    private DependenteService dependenteService;

    @Tag(name = "DEPENDENTES")
    @Operation(summary = "Salva novos dependentes")
    @PostMapping
    public ResponseEntity salvar(@RequestBody Dependente dependente){
        Dependente save = dependenteService.salvar(dependente);
        return ResponseEntity.created(URI.create("/api/dependentes" + dependente.getId())).body(save);
    }

    @Tag(name = "DEPENDENTES")
    @Operation(summary = "Lista todos os dependentes")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<DependenteDto> dependentes = dependenteService.buscaTodos(filter, pageable);
        return ResponseEntity.ok(dependentes);
    }

    @Tag(name = "DEPENDENTES")
    @Operation(summary = "Busca dependentes por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Dependente dependente = dependenteService.buscaPorId(id);
        return ResponseEntity.ok().body(dependente);
    }

    @Tag(name = "DEPENDENTES")
    @Operation(summary = "Deleta dependentes por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        dependenteService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "DEPENDENTES")
    @Operation(summary = "Atualiza dependentes por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Dependente entity){
        Dependente alterado = dependenteService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}
