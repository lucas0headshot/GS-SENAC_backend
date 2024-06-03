package com.senac.gestaocurso.service;


import com.senac.gestaocurso.models.Dependente;
import com.senac.gestaocurso.repository.DependentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DependentesService {
    @Autowired
    private DependentesRepository dependentesRepository;
    public Dependente salvar(Dependente entity) {
        return dependentesRepository.save(entity);
    }
    public Page<Dependente> buscaTodos(Pageable pageable) {
        return dependentesRepository.findAll(pageable);
    }
    public Dependente buscaPorId(Long id) {
        return dependentesRepository.findById(id).orElse(null);
    }
    public Dependente alterar(Long id, Dependente alterado) {
        Optional<Dependente> encontrado = dependentesRepository.findById(id);
        if ((encontrado.isPresent())) {
            Dependente dependente = encontrado.get();
            dependente.setNome(alterado.getNome());
            dependente.setEscolaridade(alterado.getEscolaridade());
            dependente.setDataNasc(alterado.getDataNasc());
            return dependentesRepository.save(dependente);
        }
        return null;
    }
    public void remover(Long id) {dependentesRepository.deleteById(id);
    }
}
