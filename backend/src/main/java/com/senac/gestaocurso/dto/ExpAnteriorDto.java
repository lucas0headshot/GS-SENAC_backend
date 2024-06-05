package com.senac.gestaocurso.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class ExpAnteriorDto implements Serializable {
    private final Long id;
    private final String descricao;
    private final LocalDate periodoFinal;
    private final LocalDate periodoInicial;

    public ExpAnteriorDto(Long id, String descricao, LocalDate periodoFinal, LocalDate periodoInicial) {
        this.id = id;
        this.descricao = descricao;
        this.periodoFinal = periodoFinal;
        this.periodoInicial = periodoInicial;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getPeriodoFinal() {
        return periodoFinal;
    }

    public LocalDate getPeriodoInicial() {
        return periodoInicial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpAnteriorDto entity = (ExpAnteriorDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.descricao, entity.descricao) &&
                Objects.equals(this.periodoFinal, entity.periodoFinal) &&
                Objects.equals(this.periodoInicial, entity.periodoInicial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, periodoFinal, periodoInicial);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "descricao = " + descricao + ", " +
                "periodoFinal = " + periodoFinal + ", " +
                "periodoInicial = " + periodoInicial + ")";
    }
}