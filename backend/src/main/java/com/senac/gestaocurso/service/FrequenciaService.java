package com.senac.gestaocurso.service;

import com.senac.gestaocurso.models.domain.Frequencia;
import com.senac.gestaocurso.repository.FrequenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FrequenciaService {
    @Autowired
    private FrequenciaRepository frequenciaRepository;
    public Frequencia salvar(Frequencia entity) {
        return frequenciaRepository.save(entity);
    }
    public Page<Frequencia> buscaTodos(Pageable pageable) {
        return frequenciaRepository.findAll(pageable);
    }
    public Frequencia buscaPorId(Long id) {
        return frequenciaRepository.findById(id).orElse(null);
    }
    public Frequencia alterar(Long id, Frequencia alterado) {
        Optional<Frequencia> encontrado = frequenciaRepository.findById(id);
        if ((encontrado.isPresent())) {
            Frequencia frequencia = encontrado.get();
            frequencia.setFrequencia(alterado.getFrequencia());
            frequencia.setAula(alterado.getAula());
            frequencia.setInscricao(alterado.getInscricao());

            return frequenciaRepository.save(frequencia);
        }
        return null;
    }
    public void remover(Long id) {frequenciaRepository.deleteById(id);
    }
}

