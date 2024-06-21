package com.senac.gestaocurso.service;


import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.Dependente;
import com.senac.gestaocurso.repository.DependentesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DependentesService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DependentesRepository dependentesRepository;

    public Dependente salvar(Dependente entity) {
        return dependentesRepository.save(entity);
    }

    public Page<Dependente> buscaTodos(Pageable pageable) {
        var list = dependentesRepository.findAll(pageable);

        if (list.isEmpty()){
            throw new NotFoundException("Nenhum dependente encontrado");
        }

        return list;
    }

    public Dependente buscaPorId(Long id) {
        return dependentesRepository.findById(id).orElseThrow(() -> new NotFoundException("Dependente não encontrado"));
    }

    public Dependente alterar(Long id, Dependente alterado) {
        Optional<Dependente> encontrado = dependentesRepository.findById(id);
        if ((encontrado.isPresent())) {
            Dependente dependente = encontrado.get();
            modelMapper.map(alterado, dependente);
            return dependentesRepository.save(dependente);
        }
        throw new NotFoundException("Dependente não encontrado");
    }

    public void remover(Long id) {
        dependentesRepository.deleteById(id);
    }
}
