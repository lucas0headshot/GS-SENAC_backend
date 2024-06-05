package com.senac.gestaocurso.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class AvaliacaoDto implements Serializable {
    private final Long id;
    private final String nome;
    private final Integer nota;
    private final LocalDate data;

    public AvaliacaoDto(Long id, String nome, Integer nota, LocalDate data) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNota() {
        return nota;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoDto entity = (AvaliacaoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.nota, entity.nota) &&
                Objects.equals(this.data, entity.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nota, data);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ", " +
                "nota = " + nota + ", " +
                "data = " + data + ")";
    }
}