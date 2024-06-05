package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.enums.Escolaridade;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class DependentesDto implements Serializable {
    private final String nome;
    private final Escolaridade escolaridade;
    private final LocalDate dataNasc;

    public DependentesDto(String nome, Escolaridade escolaridade, LocalDate dataNasc) {
        this.nome = nome;
        this.escolaridade = escolaridade;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DependentesDto entity = (DependentesDto) o;
        return Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.escolaridade, entity.escolaridade) &&
                Objects.equals(this.dataNasc, entity.dataNasc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, escolaridade, dataNasc);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nome = " + nome + ", " +
                "escolaridade = " + escolaridade + ", " +
                "dataNasc = " + dataNasc + ")";
    }
}