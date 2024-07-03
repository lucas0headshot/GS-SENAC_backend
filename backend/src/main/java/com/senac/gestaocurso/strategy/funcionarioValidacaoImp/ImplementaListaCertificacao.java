package com.senac.gestaocurso.strategy.funcionarioValidacaoImp;

import com.senac.gestaocurso.models.domain.Certificacao;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.strategy.ValidarImplementacaoListasStrategy;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImplementaListaCertificacao implements ValidarImplementacaoListasStrategy {
    @Override
    public void lista(Funcionario funcionario) {
        if (validaLista(funcionario)) {
            List<Certificacao> certificacaoList = funcionario.getCertificacoes()
                    .stream()
                    .map(certificacoesIn -> new Certificacao(
                            certificacoesIn.getNome(),
                            certificacoesIn.getCargaHoraria(),
                            certificacoesIn.getDataEmissao(),
                            funcionario))
                    .collect(Collectors.toList());

            funcionario.setCertificacoes(certificacaoList);
        }
    }

    private Boolean validaLista(Funcionario funcionario){
        return !funcionario.getCertificacoes().isEmpty();
    }
}
