package com.senac.gestaocurso.strategy.funcionarioValidacaoImp;

import com.senac.gestaocurso.models.DadosBancario;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.strategy.ValidarImplementacaoListasStrategy;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImplementaListaDadoBancario implements ValidarImplementacaoListasStrategy {
    @Override
    public void lista(Funcionario funcionario) {
        if (validaLista(funcionario)) {
            List<DadosBancario> dadosBancarioList = funcionario.getDadosBancarios()
                    .stream()
                    .map(dadosBancariosIn -> new DadosBancario(
                            dadosBancariosIn.getBanco(),
                            dadosBancariosIn.getAgencia(),
                            dadosBancariosIn.getAgencia(),
                            dadosBancariosIn.getTipoContaBancaria(),
                            funcionario))
                    .collect(Collectors.toList());

            funcionario.setDadosBancarios(dadosBancarioList);
        }
    }

    private Boolean validaLista(Funcionario funcionario){
        return !funcionario.getDadosBancarios().isEmpty();
    }
}
