package com.senac.gestaocurso.service;


import com.senac.gestaocurso.dto.DependenteDto;
import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.Dependente;
import com.senac.gestaocurso.repository.DependenteRepository;
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
    private DependenteRepository dependenteRepository;

    public Dependente salvar(Dependente entity) {
        return dependenteRepository.save(entity);
    }

    public Page<DependenteDto> buscaTodos(String filter, Pageable pageable) {
        Page<Dependente> dependentePage = dependenteRepository.findAll(filter, Dependente.class, pageable);

        if (dependentePage.isEmpty()){
            throw new NotFoundException("Nenhum Dependente encontrado");
        }
        return dependentePage.map(DependenteDto::fromEntity);
    }

    public Dependente buscaPorId(Long id) {
        return dependenteRepository.findById(id).orElseThrow(() -> new NotFoundException("Dependente não encontrado"));
    }

    public Dependente alterar(Long id, Dependente alterado) {
        Optional<Dependente> encontrado = dependenteRepository.findById(id);
        if ((encontrado.isPresent())) {
            Dependente dependente = encontrado.get();
            modelMapper.map(alterado, dependente);
            return dependenteRepository.save(dependente);
        }
        throw new NotFoundException("Dependente não encontrado");
    }

    public void remover(Long id) {
        dependenteRepository.deleteById(id);
    }
}
