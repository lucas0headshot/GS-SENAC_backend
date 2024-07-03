package com.senac.gestaocurso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.gestaocurso.enums.Escolaridade;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Dependente extends EntityID {
    @Column
    private String nome;

    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    @Column
    private LocalDate dataNasc;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id")
    @JsonIgnore
    private Funcionario funcionario;

    public Dependente() {
    }

    public Dependente(String nome, Escolaridade escolaridade, LocalDate dataNasc, Funcionario funcionario) {
        this.nome = nome;
        this.escolaridade = escolaridade;
        this.dataNasc = dataNasc;
        this.funcionario = funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return "Dependentes{" +
                "nome='" + nome + '\'' +
                ", escolaridade=" + escolaridade +
                ", dataNasc=" + dataNasc +
                '}';
    }

    public static class Builder{
        private String nome;
        private Escolaridade escolaridade;
        private LocalDate dataNasc;
        private Funcionario funcionario;

        private Builder(){

        }

        public Builder create(){
            return new Builder();
        }

        public static Builder from(Dependente dependente){
            Builder builder = new Builder();

            builder.nome = dependente.nome;;
            builder.escolaridade = dependente.escolaridade;
            builder.dataNasc = dependente.dataNasc;
            builder.funcionario = dependente.funcionario;

            return builder;
        }

        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder escolaridade(Escolaridade escolaridade){
            this.escolaridade = escolaridade;
            return this;
        }

        public Builder dataNasc(LocalDate dataNasc){
            this.dataNasc = dataNasc;
            return this;
        }

        public Builder funcionario(Funcionario funcionario){
            this.funcionario = funcionario;
            return this;
        }

        public Dependente build(){
            return new Dependente(nome, escolaridade, dataNasc, funcionario);
        }
    }
}