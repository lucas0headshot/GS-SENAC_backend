package com.senac.gestaocurso.resource;



import com.senac.gestaocurso.models.Inscricao;
import com.senac.gestaocurso.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;



@RestController
@RequestMapping("api/inscricao")
public class InscricaoController extends AbstractController {
    @Autowired
    private InscricaoService inscricaoService;



    @PostMapping()
    public ResponseEntity salvar(@RequestBody Inscricao inscricao){
        Inscricao save = inscricaoService.salvar(inscricao);
        return ResponseEntity.created(URI.create("/api/inscricao" + inscricao.getId())).body(save);
    }



    @GetMapping
    public  ResponseEntity findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Inscricao> inscricao = inscricaoService.buscaTodos(pageable);
        return ResponseEntity.ok(inscricao);
    }

    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Inscricao inscricao = inscricaoService.buscaPorId(id);
        return ResponseEntity.ok().body(inscricao);
    }



    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        inscricaoService.remover(id);
        return ResponseEntity.noContent().build();
    }



    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Inscricao entity){
        Inscricao inscricao = inscricaoService.alterar(id, entity);
        return  ResponseEntity.ok().body(inscricao);
    }
}