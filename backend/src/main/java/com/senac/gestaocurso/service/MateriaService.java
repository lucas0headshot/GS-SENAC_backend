package com.senac.gestaocurso.service;

import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.models.Materia;
import com.senac.gestaocurso.repository.FuncionarioRepository;
import com.senac.gestaocurso.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {
    @Autowired
    private MateriaRepository materiaRepository;
    public Materia salvar(Materia entity) {return materiaRepository.save(entity);}
    public List<Materia> buscaTodos() {
        return materiaRepository.findAll();
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

