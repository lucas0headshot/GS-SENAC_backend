package com.senac.gestaocurso.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class AulaDto implements Serializable {
    private final Long id;
    private final LocalDate dia;

    public AulaDto(Long id, LocalDate dia) {
        this.id = id;
        this.dia = dia;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDia() {
        return dia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AulaDto entity = (AulaDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.dia, entity.dia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dia);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "dia = " + dia + ")";
    }
}