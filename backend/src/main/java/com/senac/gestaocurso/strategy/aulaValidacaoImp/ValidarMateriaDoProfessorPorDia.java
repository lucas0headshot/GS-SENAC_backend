package com.senac.gestaocurso.strategy.aulaValidacaoImp;

import com.senac.gestaocurso.enterprise.ValidationException;
import com.senac.gestaocurso.models.Aula;
import com.senac.gestaocurso.repository.AulaRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoAulaStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ValidarMateriaDoProfessorPorDia implements NovaValidacaoAulaStrategy {

    @Autowired
    private AulaRepository repository;

    @Override
    public void validar(Aula aula) {
        if (validaMateriaPorDia(aula.getDia(), aula.getProfessor().getId())){
            throw new ValidationException("Esse professor já está com aula neste dia");
        }
    }

    private boolean validaMateriaPorDia(LocalDate dia, Long idProfessor){
        return repository.findByDia(dia) != null &&
                repository.findByProfessor(idProfessor) != null;
    }
}
