package com.senac.gestaocurso.strategy.funcionarioValidacaoImp;

import com.senac.gestaocurso.models.ExperienciaAnterior;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.strategy.ValidarImplementacaoListasStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImplementaListaExperienciaAnterior implements ValidarImplementacaoListasStrategy {
    @Override
    public void lista(Funcionario funcionario) {
        if (validaLista(funcionario)) {
            List<ExperienciaAnterior> experienciaAnteriorList = funcionario.getExpAnterior()
                    .stream()
                    .map(expAnteriorIn -> new ExperienciaAnterior(
                            expAnteriorIn.getDescricao(),
                            expAnteriorIn.getCargo(),
                            expAnteriorIn.getPeriodoFinal(),
                            expAnteriorIn.getPeriodoInicial(),
                            funcionario))
                    .collect(Collectors.toList());

            funcionario.setExpAnterior(experienciaAnteriorList);
        }
    }

    private boolean validaLista(Funcionario funcionario){
        if (!funcionario.getExpAnterior().isEmpty()) return true;

        return false;
    }
}
