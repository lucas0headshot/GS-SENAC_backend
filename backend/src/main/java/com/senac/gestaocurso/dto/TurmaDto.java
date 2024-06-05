package com.senac.gestaocurso.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class TurmaDto implements Serializable {
    private final String nome;
    private final LocalDate dataInicio;
    private final LocalDate dataFinal;
    private final String descricao;
    private final Integer limiteQtdInscricao;

    public TurmaDto(String nome, LocalDate dataInicio, LocalDate dataFinal, String descricao, Integer limiteQtdInscricao) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.descricao = descricao;
        this.limiteQtdInscricao = limiteQtdInscricao;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getLimiteQtdInscricao() {
        return limiteQtdInscricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurmaDto entity = (TurmaDto) o;
        return Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.dataInicio, entity.dataInicio) &&
                Objects.equals(this.dataFinal, entity.dataFinal) &&
                Objects.equals(this.descricao, entity.descricao) &&
                Objects.equals(this.limiteQtdInscricao, entity.limiteQtdInscricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataInicio, dataFinal, descricao, limiteQtdInscricao);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nome = " + nome + ", " +
                "dataInicio = " + dataInicio + ", " +
                "dataFinal = " + dataFinal + ", " +
                "descricao = " + descricao + ", " +
                "limiteQtdInscricao = " + limiteQtdInscricao + ")";
    }
}