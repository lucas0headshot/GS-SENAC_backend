package com.senac.gestaocurso.service;

import com.senac.gestaocurso.models.domain.Materia;
import com.senac.gestaocurso.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MateriaService {
    @Autowired
    private MateriaRepository materiaRepository;
    public Materia salvar(Materia entity) {
        return materiaRepository.save(entity);
    }
    public Page<Materia> buscaTodos(Pageable pageable) {
        return materiaRepository.findAll(pageable);
    }
    public Materia buscaPorId(Long id) {
        return materiaRepository.findById(id).orElse(null);
    }
    public Materia alterar(Long id, Materia alterado) {
        Optional<Materia> encontrado = materiaRepository.findById(id);
        if ((encontrado.isPresent())) {
            Materia materia = encontrado.get();
            materia.setNome(alterado.getNome());
            materia.setCargaHoraria(alterado.getCargaHoraria());
            return materiaRepository.save(materia);
        }
        return null;
    }
    public void remover(Long id) {materiaRepository.deleteById(id);
    }

}

