package com.senac.gestaocurso.strategy.funcionarioValidacaoImp;

import com.senac.gestaocurso.models.Dependente;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.strategy.ValidarImplementacaoListasStrategy;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImplementaListaDependente implements ValidarImplementacaoListasStrategy {
    @Override
    public void lista(Funcionario funcionario) {
     if (validaLista(funcionario)){
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

    private Boolean validaLista(Funcionario funcionario){
        return !funcionario.getDependentes().isEmpty();
    }
}
