package com.senac.gestaocurso.service;

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

    public Page<Aula> buscaTodos(Pageable pageable){
        var list = aulaRepository.findAll(pageable);
        if (list.isEmpty()){
            throw new NotFoundException("nenhuma aula encontrada");
        }
        return list;
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
