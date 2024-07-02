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

    public Materia(Builder builder) {
        this.nome = builder.nome;
        this.cargaHoraria = builder.cargaHoraria;
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

    public static class Builder {
        private String nome;
        private Integer cargaHoraria;

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

        public Materia build() {
            return new Materia(this);
        }
    }
}