package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.dto.FuncionarioDto;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.service.FuncionarioService;
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
@RequestMapping("/api/funcionario")

public class FuncionarioController extends AbstractController{
    @Autowired
    private FuncionarioService funcionarioService;

    @Tag(name = "FUNCIONARIO")
    @Operation(summary = "Salva novo funcionario")
    @PostMapping
    public ResponseEntity salvar(@RequestBody Funcionario funcionario){
        Funcionario save = funcionarioService.salvar(funcionario);
        return ResponseEntity.created(URI.create("/api/funcionario" + funcionario.getId())).body(save);
    }

    @Tag(name = "FUNCIONARIO")
    @Operation(summary = "Lista todos os funcionarios")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FuncionarioDto> funcionarios = funcionarioService.buscaTodos(filter, pageable);
        return ResponseEntity.ok(funcionarios);
    }

    @Tag(name = "FUNCIONARIO")
    @Operation(summary = "Busca funcionario por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Funcionario funcionario = funcionarioService.buscaPorId(id);
        return ResponseEntity.ok().body(funcionario);
    }

    @Tag(name = "FUNCIONARIO")
    @Operation(summary = "Deleta funcionario por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        funcionarioService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "FUNCIONARIO")
    @Operation(summary = "Atualiza funcionario por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Funcionario entity){
        Funcionario alterado = funcionarioService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}



