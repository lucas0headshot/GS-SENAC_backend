package com.senac.gestaocurso.strategy.aulaValidacaoImp;

import com.senac.gestaocurso.enterprise.exception.ValidationException;
import com.senac.gestaocurso.models.domain.Aula;
import com.senac.gestaocurso.strategy.NovaValidacaoAulaStrategy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidarDiaAnteriorADiaDaAula implements NovaValidacaoAulaStrategy {
    @Override
    public void validar(Aula aula) {
        if (!diaAnteriorADiaDaAula(aula.getDia())) {
            throw new ValidationException("A aula só pode ser alterada até o dia anterior à data da aula");
        }
    }

    private Boolean diaAnteriorADiaDaAula(LocalDate diaAula) {
        return LocalDate.now().isBefore(diaAula);
    }
}
