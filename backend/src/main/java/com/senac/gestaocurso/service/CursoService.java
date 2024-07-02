package com.senac.gestaocurso.service;


import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.domain.Curso;
import com.senac.gestaocurso.repository.CursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CursoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CursoRepository cursoRepository;

    public Curso salvar(Curso entity) {
        Curso curso = Curso.Builder.builder()
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .cargaHorariaTotal(entity.getCargaHorariaTotal())
                .build();
        return cursoRepository.save(curso);
    }

    public Page<Curso> buscaTodos(Pageable pageable) {
        var list = cursoRepository.findAll(pageable);

        if (list.isEmpty()){
            throw new NotFoundException("Nenhum curso encontrado");
        }

        return list;
    }

    public Curso buscaPorId(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new NotFoundException("Curso não encontrado"));
    }

    public Curso alterar(Long id, Curso alterado) {
        Optional<Curso> encontrado = cursoRepository.findById(id);
        if ((encontrado.isPresent())) {
            Curso curso = encontrado.get();
            modelMapper.map(alterado, curso);
            return cursoRepository.save(curso);
        }
        throw new NotFoundException("Curso não encontrado");
    }

    public void remover(Long id) {
        cursoRepository.deleteById(id);
    }
}

