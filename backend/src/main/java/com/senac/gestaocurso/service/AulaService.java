package com.senac.gestaocurso.service;

import com.senac.gestaocurso.dto.AulaDto;
import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.domain.Aula;
import com.senac.gestaocurso.repository.AulaRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoAulaStrategy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AulaService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private NovaValidacaoAulaStrategy novaValidacaoAulaStrategy;

    public Aula salvar(Aula entity){
        novaValidacaoAulaStrategy.validar(entity);
        return aulaRepository.save(entity);
    }

    public Page<AulaDto> buscaTodos(String filter, Pageable pageable) {
        Page<Aula> aulasPage = aulaRepository.findAll(filter, Aula.class, pageable);

        if (aulasPage.isEmpty()){
            throw new NotFoundException("Nenhum funcionário encontrado");
        }
        return aulasPage.map(AulaDto::fromEntity);
    }

    public Aula buscaPorId(Long id){
        return aulaRepository.findById(id).orElseThrow(() -> new NotFoundException("aula não encontrada"));
    }

    public Aula alterar(Long id, Aula alterado){
        Optional<Aula> encontrado = aulaRepository.findById(id);
        if (encontrado.isPresent()) {
            Aula aula = encontrado.get();
            modelMapper.map(alterado, aula);
            return aulaRepository.save(aula);
        }

        throw new NotFoundException("aula não encontrada");
    }

    public void remover(Long id) {aulaRepository.deleteById(id);
    }
}
