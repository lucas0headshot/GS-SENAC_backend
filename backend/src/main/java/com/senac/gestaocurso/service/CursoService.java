package com.senac.gestaocurso.service;


import com.senac.gestaocurso.models.Curso;
import com.senac.gestaocurso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    public Curso salvar(Curso entity) {
        return cursoRepository.save(entity);
    }
    public Page<Curso> buscaTodos(Pageable pageable) {
        return cursoRepository.findAll(pageable);
    }
    public Curso buscaPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }
    public Curso alterar(Long id, Curso alterado) {
        Optional<Curso> encontrado = cursoRepository.findById(id);
        if ((encontrado.isPresent())) {
            Curso curso = encontrado.get();
            curso.setNome(alterado.getNome());
            curso.setCoordenador(alterado.getCoordenador());
            curso.setCargaHorariaTotal(alterado.getCargaHorariaTotal());
            return cursoRepository.save(curso);
        }
        return null;
    }
    public void remover(Long id) {
        cursoRepository.deleteById(id);
    }
}

