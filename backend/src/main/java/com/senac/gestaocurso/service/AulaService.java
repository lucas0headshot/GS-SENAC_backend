package com.senac.gestaocurso.service;

import com.senac.gestaocurso.models.domain.Aula;
import com.senac.gestaocurso.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;
    public Aula salvar(Aula entity) {return aulaRepository.save(entity);}
    public Page<Aula> buscaTodos(Pageable pageable) {
        return aulaRepository.findAll(pageable);
    }
    public Aula buscaPorId(Long id) {
        return aulaRepository.findById(id).orElse(null);
    }
    public Aula alterar(Long id, Aula alterado) {
        Optional<Aula> encontrado = aulaRepository.findById(id);
        if ((encontrado.isPresent())) {
            Aula aula = encontrado.get();
            aula.setMateria(alterado.getMateria());
            aula.setDia(alterado.getDia());
            return aulaRepository.save(aula);
        }
        return null;
    }
    public void remover(Long id) {aulaRepository.deleteById(id);
    }
}
