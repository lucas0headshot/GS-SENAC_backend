package com.senac.gestaocurso.strategy.impl;

import com.senac.gestaocurso.models.Dependente;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.strategy.ValidarImplementacaoListasStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValidarListaDependentes implements ValidarImplementacaoListasStrategy {


    @Override
    public void lista(Funcionario funcionario) {
     if (!funcionario.getDependentes().isEmpty()){
         List<Dependente> dependenteList = funcionario.getDependentes()
                 .stream()
                 .map(dependentesIn -> new Dependente(
                         dependentesIn.getNome(),
                         dependentesIn.getEscolaridade(),
                         dependentesIn.getDataNasc(),
                         funcionario))
                 .collect(Collectors.toList());

         funcionario.setDependentes(dependenteList);
     }
    }
}
