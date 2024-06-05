package com.senac.gestaocurso.dto;

import java.io.Serializable;
import java.util.Objects;


public class MateriaDto implements Serializable {
    private final String nome;
    private final Integer cargaHoraria;

    public MateriaDto(String nome, Integer cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MateriaDto entity = (MateriaDto) o;
        return Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.cargaHoraria, entity.cargaHoraria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cargaHoraria);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nome = " + nome + ", " +
                "cargaHoraria = " + cargaHoraria + ")";
    }
}