package com.senac.gestaocurso.service;


import com.senac.gestaocurso.models.Dependentes;
import com.senac.gestaocurso.repository.DependentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DependentesService {
    @Autowired
    private DependentesRepository dependentesRepository;
    public Dependentes salvar(Dependentes entity) {
        return dependentesRepository.save(entity);
    }
    public Page<Dependentes> buscaTodos(Pageable pageable) {
        return dependentesRepository.findAll(pageable);
    }
    public Dependentes buscaPorId(Long id) {
        return dependentesRepository.findById(id).orElse(null);
    }
    public Dependentes alterar(Long id, Dependentes alterado) {
        Optional<Dependentes> encontrado = dependentesRepository.findById(id);
        if ((encontrado.isPresent())) {
            Dependentes dependentes = encontrado.get();
            dependentes.setNome(alterado.getNome());
            dependentes.setEscolaridade(alterado.getEscolaridade());
            dependentes.setDataNasc(alterado.getDataNasc());
            return dependentesRepository.save(dependentes);
        }
        return null;
    }
    public void remover(Long id) {dependentesRepository.deleteById(id);
    }
}
