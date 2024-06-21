package com.senac.gestaocurso.service;

import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.domain.Materia;
import com.senac.gestaocurso.repository.MateriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MateriaRepository materiaRepository;

    public Materia salvar(Materia entity) {
        return materiaRepository.save(entity);
    }

    public Page<Materia> buscaTodos(Pageable pageable) {
        var list = materiaRepository.findAll(pageable);

        if (list.isEmpty()){
            throw new NotFoundException("Nenhuma matéria encontrada");
        }

        return list;
    }

    public Materia buscaPorId(Long id) {
        return materiaRepository.findById(id).orElseThrow(() -> new NotFoundException("Matéria não encontrada"));
    }

    public Materia alterar(Long id, Materia alterado) {
        Optional<Materia> encontrado = materiaRepository.findById(id);
        if ((encontrado.isPresent())) {
            Materia materia = encontrado.get();
            modelMapper.map(alterado, materia);
            return materiaRepository.save(materia);
        }
        throw new NotFoundException("Matéria não encontrada");
    }

    public void remover(Long id) {
        materiaRepository.deleteById(id);
    }

}

