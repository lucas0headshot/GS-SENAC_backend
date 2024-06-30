package com.senac.gestaocurso.strategy.inscricao;

import com.senac.gestaocurso.enterprise.exception.ValidationException;
import com.senac.gestaocurso.models.domain.Inscricao;
import com.senac.gestaocurso.models.domain.Turma;
import com.senac.gestaocurso.repository.TurmaRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoInscricaoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidarQuantidaInscricao implements NovaValidacaoInscricaoStrategy {
    
    @Autowired
    private TurmaRepository turmaRepository;
    @Override
    public void validar(Inscricao inscricao) {
        validaTurma(inscricao.getTurma().getId());
    }

    private void validaTurma(Long id) {
        Optional<Turma> ById = turmaRepository.findById(id);

        if (ById.isPresent()) {
            if (ById.get().getInscritos().size() >= ById.get().getLimiteQtdInscricao()) {
                throw new ValidationException("Essa turma já alcançou o limite máximo de inscrições");
            }
        }
    }
}
