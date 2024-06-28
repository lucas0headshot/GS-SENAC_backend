package com.senac.gestaocurso.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;



@Entity
public class Cargo extends EntityID {
    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String nivel;

    @Column(nullable = false)
    private Boolean comissionado;



    public Cargo() {
    }

    public Cargo(String descricao, String nivel, Boolean comissionado) {
        this.descricao = descricao;
        this.nivel = nivel;
        this.comissionado = comissionado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Boolean getComissionado() {
        return comissionado;
    }

    public void setComissionado(Boolean comissionado) {
        this.comissionado = comissionado;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "descricao='" + descricao + '\'' +
                ", nivel='" + nivel + '\'' +
                ", comissionado=" + comissionado +
                '}';
    }

    public static class Builder{
        private String descricao;

        private String nivel;

        private Boolean comissionado;

        private Builder(){

        }

        public static Builder create(){
            return new Builder();
        }

        public static Builder from(Cargo cargo){
            Builder builder =  new Builder();

            builder.descricao = cargo.descricao;;
            builder.nivel = cargo.nivel;
            builder.comissionado = cargo.comissionado;

            return builder;
        }

        public Builder descricao(String descricao){
            this.descricao = descricao;
            return this;
        }

        public Builder nivel(String nivel){
            this.nivel = nivel;
            return this;
        }

        public Builder comissionado(Boolean comissionado){
            this.comissionado = comissionado;
            return this;
        }

        public Cargo build() {
            return new Cargo(descricao, nivel, comissionado);
        }

    }
}