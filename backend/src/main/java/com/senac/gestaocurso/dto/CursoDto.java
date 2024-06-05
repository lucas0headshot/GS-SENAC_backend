package com.senac.gestaocurso.dto;

import java.io.Serializable;
import java.util.Objects;


public class CursoDto implements Serializable {
    private final String nome;
    private final String descricao;
    private final Integer cargaHorariaTotal;

    public CursoDto(String nome, String descricao, Integer cargaHorariaTotal) {
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoDto entity = (CursoDto) o;
        return Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.descricao, entity.descricao) &&
                Objects.equals(this.cargaHorariaTotal, entity.cargaHorariaTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, cargaHorariaTotal);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nome = " + nome + ", " +
                "descricao = " + descricao + ", " +
                "cargaHorariaTotal = " + cargaHorariaTotal + ")";
    }
}