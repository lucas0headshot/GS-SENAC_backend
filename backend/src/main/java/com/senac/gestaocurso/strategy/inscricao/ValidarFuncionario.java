package com.senac.gestaocurso.strategy.inscricao;

import com.senac.gestaocurso.enterprise.exception.ValidationException;
import com.senac.gestaocurso.models.domain.Inscricao;
import com.senac.gestaocurso.repository.InscricaoRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoInscricaoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarFuncionario implements NovaValidacaoInscricaoStrategy {

    @Autowired
    private InscricaoRepository repository;

    @Override
    public void validar(Inscricao inscricao) {
        if (funcaionarioInscrito(inscricao.getInscrito().getId())){
            throw new ValidationException("funcionario já inscrito neste curso");
        }
    }

    private boolean funcaionarioInscrito(Long id){
        return repository.findByInscritoId(id) != null;
    }
}
