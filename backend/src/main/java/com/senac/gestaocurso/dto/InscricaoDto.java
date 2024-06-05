package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.enums.Status;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class InscricaoDto implements Serializable {
    private final LocalDate data;
    private final Status status;
    private final Integer valor;

    public InscricaoDto(LocalDate data, Status status, Integer valor) {
        this.data = data;
        this.status = status;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscricaoDto entity = (InscricaoDto) o;
        return Objects.equals(this.data, entity.data) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.valor, entity.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, status, valor);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "data = " + data + ", " +
                "status = " + status + ", " +
                "valor = " + valor + ")";
    }
}