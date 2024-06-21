package com.senac.gestaocurso.strategy.aulaValidacaoImp;

import com.senac.gestaocurso.enterprise.exception.ValidationException;
import com.senac.gestaocurso.models.domain.Aula;
import com.senac.gestaocurso.repository.AulaRepository;
import com.senac.gestaocurso.repository.FuncionarioRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoAulaStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidarMateriaDoProfessorPorDia implements NovaValidacaoAulaStrategy {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public void validar(Aula aula) {
        if (validaMateriaPorDia(aula.getDia(), aula.getProfessor().getId())){
            throw new ValidationException("Esse professor já está com aula neste dia");
        }
    }

    private boolean validaMateriaPorDia(LocalDate dia, Long id){
        return aulaRepository.findByDia(dia) != null &&
                funcionarioRepository.findById(id) != null;
    }
}
