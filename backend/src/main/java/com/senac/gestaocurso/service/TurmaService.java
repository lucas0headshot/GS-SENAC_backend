package com.senac.gestaocurso.service;

import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.domain.Turma;
import com.senac.gestaocurso.repository.TurmaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TurmaService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma salvar(Turma entity) {
        return turmaRepository.save(entity);
    }

    public Page<Turma> buscaTodos(Pageable pageable) {
        var list = turmaRepository.findAll(pageable);

        if (list.isEmpty()){
            throw new NotFoundException("Nenhuma turma encontrada");
        }

        return list;
    }

    public Turma buscaPorId(Long id) {
        return turmaRepository.findById(id).orElseThrow(() -> new NotFoundException("Turma não encontrada"));
    }

    public Turma alterar(Long id, Turma alterado) {
        Optional<Turma> encontrado = turmaRepository.findById(id);
        if ((encontrado.isPresent())) {
            Turma turma = encontrado.get();
            modelMapper.map(alterado, turma);
            return turmaRepository.save(turma);
        }
        throw new NotFoundException("Turma não encontrada");
    }

    public void remover(Long id) {
        turmaRepository.deleteById(id);
    }
}

