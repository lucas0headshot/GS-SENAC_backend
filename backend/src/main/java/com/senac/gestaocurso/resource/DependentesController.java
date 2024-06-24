package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.models.Dependente;
import com.senac.gestaocurso.service.DependentesService;
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
public class DependentesController extends AbstractController{
    @Autowired
    private DependentesService dependentesService;

    @Tag(name = "DEPENDENTES")
    @Operation(summary = "Salva novos dependentes")
    @PostMapping
    public ResponseEntity salvar(@RequestBody Dependente dependente){
        Dependente save = dependentesService.salvar(dependente);
        return ResponseEntity.created(URI.create("/api/dependentes" + dependente.getId())).body(save);
    }

    @Tag(name = "DEPENDENTES")
    @Operation(summary = "Lista todos os dependentes")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Dependente> dependentes = dependentesService.buscaTodos(pageable);
        return ResponseEntity.ok(dependentes);
    }

    @Tag(name = "DEPENDENTES")
    @Operation(summary = "Busca dependentes por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Dependente dependente = dependentesService.buscaPorId(id);
        return ResponseEntity.ok().body(dependente);
    }

    @Tag(name = "DEPENDENTES")
    @Operation(summary = "Deleta dependentes por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        dependentesService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "DEPENDENTES")
    @Operation(summary = "Atualiza dependentes por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Dependente entity){
        Dependente alterado = dependentesService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}

