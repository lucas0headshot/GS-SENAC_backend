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
            List<ExperienciaAnterior> experienciaAnteriorList = funcionario.getExperienciaAnterior()
                    .stream()
                    .map(expAnteriorIn -> new ExperienciaAnterior(
                            expAnteriorIn.getDescricao(),
                            expAnteriorIn.getCargo(),
                            expAnteriorIn.getPeriodoFinal(),
                            expAnteriorIn.getPeriodoInicial(),
                            funcionario))
                    .collect(Collectors.toList());

            funcionario.setExperienciaAnterior(experienciaAnteriorList);
        }
    }

    private Boolean validaLista(Funcionario funcionario){
        return !funcionario.getExperienciaAnterior().isEmpty();
    }
}
