package com.senac.gestaocurso.dto;

import java.io.Serializable;
import java.util.Objects;


public class CargoDto implements Serializable {
    private final Long id;
    private final String descricao;
    private final String nivel;
    private final Boolean comissionado;

    public CargoDto(Long id, String descricao, String nivel, Boolean comissionado) {
        this.id = id;
        this.descricao = descricao;
        this.nivel = nivel;
        this.comissionado = comissionado;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public Boolean getComissionado() {
        return comissionado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoDto entity = (CargoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.descricao, entity.descricao) &&
                Objects.equals(this.nivel, entity.nivel) &&
                Objects.equals(this.comissionado, entity.comissionado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, nivel, comissionado);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "descricao = " + descricao + ", " +
                "nivel = " + nivel + ", " +
                "comissionado = " + comissionado + ")";
    }
}