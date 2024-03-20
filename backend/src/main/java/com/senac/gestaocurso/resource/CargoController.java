package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.models.Cargo;
import com.senac.gestaocurso.service.CargoService;
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

public class CargoController extends AbstractController {
    @Autowired
    private CargoService cargoService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Cargo cargo){
        Cargo save = cargoService.salvar(cargo);
        return ResponseEntity.created(URI.create("/cargos/salvar" + cargo.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "0") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Cargo> cargos = cargoService.buscaTodos(pageable);
        return ResponseEntity.ok(cargos);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Cargo cargo = cargoService.buscaPorId(id);
        return ResponseEntity.ok().body(cargo);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        cargoService.remover(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Cargo entity){
        Cargo alterado = cargoService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}



