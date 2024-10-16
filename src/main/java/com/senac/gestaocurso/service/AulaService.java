package com.senac.gestaocurso.service;

import com.senac.gestaocurso.dto.AulaDto;
import com.senac.gestaocurso.enterprise.exception.OkNoContent;
import com.senac.gestaocurso.models.domain.Aula;
import com.senac.gestaocurso.repository.AulaRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoAulaStrategy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private List<NovaValidacaoAulaStrategy> novaValidacaoAulaStrategy;

    public Aula salvar(Aula entity){
        novaValidacaoAulaStrategy.forEach(validate -> validate.validar(entity));
        Aula aula = Aula.Builder.builder()
                .dia(entity.getDia())
                .materia(entity.getMateria())
                .professor(entity.getProfessor())
                .frequencias(entity.getFrequencias())
                .build();
        return aulaRepository.save(aula);
    }

    public Page<AulaDto> buscaTodos(String filter, Pageable pageable) {
        Page<Aula> aulasPage = aulaRepository.findAll(filter, Aula.class, pageable);

        if (aulasPage.isEmpty()){
            throw new OkNoContent("Nenhum funcionário encontrado");
        }

        return aulasPage.map(AulaDto::fromEntity);
    }

    public Aula buscaPorId(Long id){
        return aulaRepository.findById(id).orElseThrow(() -> new OkNoContent("aula não encontrada"));
    }

    public Aula alterar(Long id, Aula alterado){
        Optional<Aula> encontrado = aulaRepository.findById(id);

        if (encontrado.isPresent()) {
            Aula aula = encontrado.get();
            modelMapper.map(alterado, aula);
            novaValidacaoAulaStrategy.forEach(validacao -> validacao.validar(aula));
            return aulaRepository.save(aula);
        }

        throw new OkNoContent("Aula não encontrada");
    }

    public void remover(Long id) {aulaRepository.deleteById(id);}
}
