package com.senac.gestaocurso.strategy.inscricao;

import com.senac.gestaocurso.enterprise.exception.ValidationException;
import com.senac.gestaocurso.models.domain.Curso;
import com.senac.gestaocurso.models.domain.Inscricao;
import com.senac.gestaocurso.repository.CursoRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoInscricaoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidarQuantidaInscricao implements NovaValidacaoInscricaoStrategy {
    
    @Autowired
    private CursoRepository repository;
    @Override
    public void validar(Inscricao inscricao) {
        validaTurma(inscricao.getCurso().getId());
    }

    private void validaTurma(Long id) {
        Optional<Curso> ById = repository.findById(id);

        if (ById.isPresent()) {
            if (ById.get().getInscritos().size() >= ById.get().getLimiteQtdInscricao()) {
                throw new ValidationException("Essa turma já alcançou o limite máximo de inscrições");
            }
        }
    }
}
