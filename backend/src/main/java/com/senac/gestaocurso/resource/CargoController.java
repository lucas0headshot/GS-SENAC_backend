package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.dto.CargoDto;
import com.senac.gestaocurso.models.Cargo;
import com.senac.gestaocurso.service.CargoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cargos")

public class CargoController extends AbstractController{
    @Autowired
    private CargoService cargoService;

    @Tag(name = "CARGOS")
    @Operation(summary = "Salvar novos cargos")
    @PostMapping()
    public ResponseEntity salvar(@RequestBody Cargo cargo){
        Cargo save = cargoService.salvar(cargo);
        return ResponseEntity.created(URI.create("/cargos/salvar" + cargo.getId())).body(save);
    }

    @Tag(name = "CARGOS")
    @Operation(summary = "Lista todos os cargos")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CargoDto> cargos = cargoService.buscaTodos(filter,pageable);
        return ResponseEntity.ok(cargos);
    }

    @Tag(name = "CARGOS")
    @Operation(summary = "Busca cargo por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Cargo cargo = cargoService.buscaPorId(id);
        return ResponseEntity.ok().body(cargo);
    }

    @Tag(name = "CARGOS")
    @Operation(summary = "Deleta cargo por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        cargoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "CARGOS")
    @Operation(summary = "Atualiza cargo pelo ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Cargo entity){
        Cargo alterado = cargoService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}



