package com.senac.gestaocurso.strategy.impl;

import com.senac.gestaocurso.models.ExpAnterior;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.strategy.ValidarImplementacaoListasStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValidarListaExpAnterior implements ValidarImplementacaoListasStrategy {
    @Override
    public void lista(Funcionario funcionario) {
        if (!funcionario.getExpAnterior().isEmpty()) {
            List<ExpAnterior> expAnteriorList = funcionario.getExpAnterior()
                    .stream()
                    .map(expAnteriorIn -> new ExpAnterior(
                            expAnteriorIn.getDescricao(),
                            expAnteriorIn.getCargo(),
                            expAnteriorIn.getPeriodoFinal(),
                            expAnteriorIn.getPeriodoInicial(),
                            funcionario))
                    .collect(Collectors.toList());

            funcionario.setExpAnterior(expAnteriorList);
        }
    }
}
