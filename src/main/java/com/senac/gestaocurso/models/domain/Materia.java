package com.senac.gestaocurso.models.domain;

import com.senac.gestaocurso.models.EntityID;
import jakarta.persistence.*;

@Entity
public class Materia extends EntityID {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Materia() {
    }

    public Materia(Builder builder) {
        this.nome = builder.nome;
        this.cargaHoraria = builder.cargaHoraria;
        this.curso = builder.curso;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }


    @Override
    public String toString() {
        return "Materia{" +
                "nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", curso=" + curso +
                '}';
    }

    public static class Builder {
        private String nome;
        private Integer cargaHoraria;
        private Curso curso;

        public Builder(){

        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder cargaHoraria(Integer cargaHoraria){
            this.cargaHoraria = cargaHoraria;
            return this;
        }

        public Builder curso(Curso curso) {
            this.curso = curso;
            return this;
        }

        public Materia build() {
            return new Materia(this);
        }
    }
}