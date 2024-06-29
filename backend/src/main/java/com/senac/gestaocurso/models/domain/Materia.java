package com.senac.gestaocurso.models.domain;

import com.senac.gestaocurso.models.EntityID;
import jakarta.persistence.*;

@Entity
public class Materia extends EntityID {
    @Column
    private String nome;

    @Column
    private Integer cargaHoraria;

    public Materia() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
