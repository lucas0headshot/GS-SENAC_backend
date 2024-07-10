package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.dto.FrequenciaDto;
import com.senac.gestaocurso.models.domain.Frequencia;
import com.senac.gestaocurso.service.FrequenciaService;
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
@RequestMapping("api/frequencia")
public class FrequenciaController extends AbstractController{
    @Autowired
    private FrequenciaService frequenciaService;

    @Tag(name = "FREQUENCIA")
    @Operation(summary = "Salva nova frequencia")
    @PostMapping
    public ResponseEntity salvar(@RequestBody Frequencia frequencia){
        Frequencia save = frequenciaService.salvar(frequencia);
        return ResponseEntity.created(URI.create("/api/frequencia" + frequencia.getId())).body(save);
    }

    @Tag(name = "FREQUENCIA")
    @Operation(summary = "Lista todas as frequencias")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FrequenciaDto> frequencias = frequenciaService.buscaTodos(filter, pageable);
        return ResponseEntity.ok(frequencias);
    }

    @Tag(name = "FREQUENCIA")
    @Operation(summary = "Busca frequencia por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Frequencia frequencia = frequenciaService.buscaPorId(id);
        return ResponseEntity.ok().body(frequencia);
    }

    @Tag(name = "FREQUENCIA")
    @Operation(summary = "Deleta frequencia por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        frequenciaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "FREQUENCIA")
    @Operation(summary = "Atualiza frequencia por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Frequencia entity){
        Frequencia alterado = frequenciaService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}
