package com.senac.gestaocurso.strategy.impl;

import com.senac.gestaocurso.models.Certificacoes;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.strategy.ValidarImplementacaoListasStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValidarListaCertificacoes implements ValidarImplementacaoListasStrategy {
    @Override
    public void lista(Funcionario funcionario) {
        if (!funcionario.getCertificacoes().isEmpty()) {
            List<Certificacoes> certificacoesList = funcionario.getCertificacoes()
                    .stream()
                    .map(certificacoesIn -> new Certificacoes(
                            certificacoesIn.getNome(),
                            certificacoesIn.getCargaHoraria(),
                            certificacoesIn.getDataEmissao(),
                            funcionario))
                    .collect(Collectors.toList());

            funcionario.setCertificacoes(certificacoesList);
        }
    }
}
