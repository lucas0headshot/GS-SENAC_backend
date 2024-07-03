package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.dto.DadosBancarioDto;
import com.senac.gestaocurso.models.DadosBancario;
import com.senac.gestaocurso.service.DadosBancarioService;
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
public class DadosBancarioController extends AbstractController{
    @Autowired
    private DadosBancarioService dadosBancarioService;

    @Tag(name = "BANCARIOS")
    @Operation(summary = "Salva novos dados bancarios")
    @PostMapping
    public ResponseEntity salvar(@RequestBody DadosBancario dadosBancario){
        DadosBancario save = dadosBancarioService.salvar(dadosBancario);
        return ResponseEntity.created(URI.create("/api/dadosbancarios" + dadosBancario.getId())).body(save);
    }

    @Tag(name = "BANCARIOS")
    @Operation(summary = "Lista todos dados bancarios")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<DadosBancarioDto> dadosBancarios = dadosBancarioService.buscaTodos(filter, pageable);
        return ResponseEntity.ok(dadosBancarios);
    }

    @Tag(name = "BANCARIOS")
    @Operation(summary = "Busca dados bancarios por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        DadosBancario dadosBancario = dadosBancarioService.buscaPorId(id);
        return ResponseEntity.ok().body(dadosBancario);
    }

    @Tag(name = "BANCARIOS")
    @Operation(summary = "Deleta dados bancarios por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        dadosBancarioService.remover(id);
        return ResponseEntity.noContent().build();
    }
    @Tag(name = "BANCARIOS")
    @Operation(summary = "Atualiza dados bancarios por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody DadosBancario entity){
        DadosBancario alterado = dadosBancarioService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}
