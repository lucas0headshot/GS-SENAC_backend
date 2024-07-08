package com.senac.gestaocurso.strategy;

import com.senac.gestaocurso.models.domain.Inscricao;

public interface NovaValidacaoInscricaoStrategy {
    void validar(Inscricao inscricao);
}
