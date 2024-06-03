package com.senac.gestaocurso.service;


import com.senac.gestaocurso.models.ExperienciaAnterior;
import com.senac.gestaocurso.repository.ExperienciaAnteriorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ExperienciaAnteriorService {

    @Autowired
    private ExperienciaAnteriorRepository experienciaAnteriorRepository;
    public ExperienciaAnterior salvar(ExperienciaAnterior entity) {
        return experienciaAnteriorRepository.save(entity);
    }
    public Page<ExperienciaAnterior> buscaTodos(Pageable pageable) {
        return experienciaAnteriorRepository.findAll(pageable);
    }
    public ExperienciaAnterior buscaPorId(Long id) {
        return experienciaAnteriorRepository.findById(id).orElse(null);
    }
    public ExperienciaAnterior alterar(Long id, ExperienciaAnterior alterado) {
        Optional<ExperienciaAnterior> encontrado = experienciaAnteriorRepository.findById(id);
        if ((encontrado.isPresent())) {
            ExperienciaAnterior experienciaAnterior = encontrado.get();
            experienciaAnterior.setCargo(alterado.getCargo());
            experienciaAnterior.setDescricao(alterado.getDescricao());
            experienciaAnterior.setPeriodoInicial(alterado.getPeriodoInicial());
            experienciaAnterior.setPeriodoFinal(alterado.getPeriodoFinal());
            return experienciaAnteriorRepository.save(experienciaAnterior);
        }
        return null;
    }
    public void remover(Long id) {
        experienciaAnteriorRepository.deleteById(id);
    }

}

