package com.senac.gestaocurso.resource;



import com.senac.gestaocurso.models.Chamada;
import com.senac.gestaocurso.service.ChamadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.awt.print.Pageable;



@RestController
@RequestMapping("api/chamada")
public class ChamadaController extends AbstractController {
    @Autowired
    private ChamadaService service;



    @PostMapping
    public ResponseEntity salvar(@RequestBody Chamada chamada) {
        return ResponseEntity.ok(service.salvar(chamada));
    }



    @GetMapping
    public ResponseEntity buscaTodos(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<Chamada> chamadas = service.buscaTodos(pageable);
        return ResponseEntity.ok(chamadas);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscaPorId(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(service.buscaPorId(id));
    }



    @PostMapping("/{id}")
    public ResponseEntity atualizar(@RequestParam("id") Long id, @RequestBody Chamada chamada) {
        return ResponseEntity.ok().body(service.alterar(id, chamada));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity remover(@RequestParam("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}