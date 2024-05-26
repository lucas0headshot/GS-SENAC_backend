package com.senac.gestaocurso.strategy.funcionarioValidacaoImp;

import com.senac.gestaocurso.models.DadosBancarios;
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
            List<DadosBancarios> dadosBancariosList = funcionario.getDadosBancarios()
                    .stream()
                    .map(dadosBancariosIn -> new DadosBancarios(
                            dadosBancariosIn.getBanco(),
                            dadosBancariosIn.getAgencia(),
                            dadosBancariosIn.getAgencia(),
                            dadosBancariosIn.getTipoContaBancaria(),
                            funcionario))
                    .collect(Collectors.toList());

            funcionario.setDadosBancarios(dadosBancariosList);
        }
    }

    private boolean validaLista(Funcionario funcionario){
        if (!funcionario.getDadosBancarios().isEmpty()) return true;

        return false;
    }
}
