package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.dto.InscricaoDto;
import com.senac.gestaocurso.enterprise.exception.ValidationException;
import com.senac.gestaocurso.models.domain.Frequencia;
import com.senac.gestaocurso.models.domain.Inscricao;
import com.senac.gestaocurso.repository.AulaRepository;
import com.senac.gestaocurso.repository.FrequenciaRepository;
import com.senac.gestaocurso.repository.MateriaRepository;
import com.senac.gestaocurso.service.FrequenciaService;
import com.senac.gestaocurso.service.InscricaoService;
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
import java.util.Optional;

@RestController
@RequestMapping("api/inscricoes")
public class InscricaoController extends AbstractController{
    @Autowired
    private InscricaoService inscricaoService;
    @Autowired
    private MateriaRepository materiaRepository;
    @Autowired
    private AulaRepository aulaRepository;
    @Autowired
    private FrequenciaRepository frequenciaRepository;
    @Autowired
    private FrequenciaService frequenciaService;

    @Tag(name = "INSCRICAO")
    @Operation(summary = "Salva nova inscricao")
    @PostMapping
    public ResponseEntity salvar(@RequestBody Inscricao inscricao){
        Inscricao save = inscricaoService.salvar(inscricao);

//        inscricao.getCurso().getMaterias().forEach(materia -> {
//            aulaRepository.findByMateriaId(materia.getId()).forEach(aula -> {
//                Optional<Frequencia> frequenciaOptional = frequenciaRepository.findByAulaIdAndAlunoId(aula.getId(), inscricao.getId());
//
//                if (frequenciaOptional.isEmpty()) {
//                    Frequencia frequencia = new Frequencia.Builder()
//                            .aula(aula)
//                            .aluno(inscricao)
//                            .frequencia(false)
//                            .build();
//                    frequenciaService.salvar(frequencia);
//                }
//            });
//        });

        inscricao.getCurso().getMaterias().forEach(materia ->
                aulaRepository.findByMateriaId(materia.getId()).forEach(aula -> {
                    frequenciaRepository.findByAulaIdAndAlunoId(aula.getId(), inscricao.getId())
                            .or(() -> Optional.of(frequenciaService.salvar(new Frequencia.Builder()
                                    .aula(aula)
                                    .aluno(inscricao)
                                    .frequencia(false)
                                    .build())))
                            .ifPresent(frequencia -> {});
                })
        );
        return ResponseEntity.created(URI.create("/api/inscricao" + inscricao.getId())).body(save);
    }

    @Tag(name = "INSCRICAO")
    @Operation(summary = "Lista todas as inscricoes")
    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<InscricaoDto> inscricao = inscricaoService.buscaTodos(filter, pageable);
        return ResponseEntity.ok(inscricao);
    }

    @Tag(name = "INSCRICAO")
    @Operation(summary = "Busca inscricao por ID")
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Inscricao inscricao = inscricaoService.buscaPorId(id);
        return ResponseEntity.ok().body(inscricao);
    }

    @Tag(name = "INSCRICAO")
    @Operation(summary = "Deleta inscricao por ID")
    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        inscricaoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "INSCRICAO")
    @Operation(summary = "Atualiza inscricao por ID")
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Inscricao entity){
        Inscricao inscricao = inscricaoService.alterar(id, entity);
        return  ResponseEntity.ok().body(inscricao);
    }
}
