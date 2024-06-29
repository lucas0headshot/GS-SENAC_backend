package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.dto.DadosBancarioDto;
import com.senac.gestaocurso.models.DadosBancario;
import com.senac.gestaocurso.service.DadosBancariosService;
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
@RequestMapping("api/dadosbancarios")
public class DadosBancariosController extends AbstractController{
    @Autowired
    private DadosBancariosService dadosBancariosService;

    @Tag(name = "BANCARIOS")
    @Operation(summary = "Salva novos dados bancarios")
    @PostMapping
    public ResponseEntity salvar(@RequestBody DadosBancario dadosBancario){
        DadosBancario save = dadosBancariosService.salvar(dadosBancario);
        return ResponseEntity.created(URI.create("/api/dadosbancarios" + dadosBancario.getId())).body(save);
    }
    @Tag(name = "BANCARIOS")
    @Operation(summary = "Lista todos dados bancarios")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<DadosBancarioDto> dadosBancarios = dadosBancariosService.buscaTodos(filter, pageable);
        return ResponseEntity.ok(dadosBancarios);
    }

    @Tag(name = "BANCARIOS")
    @Operation(summary = "Busca dados bancarios por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        DadosBancario dadosBancario = dadosBancariosService.buscaPorId(id);
        return ResponseEntity.ok().body(dadosBancario);
    }

    @Tag(name = "BANCARIOS")
    @Operation(summary = "Deleta dados bancarios por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        dadosBancariosService.remover(id);
        return ResponseEntity.noContent().build();
    }
    @Tag(name = "BANCARIOS")
    @Operation(summary = "Atualiza dados bancarios por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody DadosBancario entity){
        DadosBancario alterado = dadosBancariosService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}

