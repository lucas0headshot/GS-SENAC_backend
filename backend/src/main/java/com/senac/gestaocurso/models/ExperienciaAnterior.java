package com.senac.gestaocurso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ExperienciaAnterior extends EntityID {
    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @Column(nullable = false)
    private LocalDate periodoFinal;

    @Column(nullable = false)
    private LocalDate periodoInicial;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    @JsonIgnore
    private Funcionario funcionario;

    public ExperienciaAnterior() {
    }

    public ExperienciaAnterior(String descricao, Cargo cargo, LocalDate periodoFinal, LocalDate peridoInicial, Funcionario funcionario) {
        this.descricao = descricao;
        this.cargo = cargo;
        this.periodoFinal = periodoFinal;
        this.periodoInicial = peridoInicial;
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public LocalDate getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(LocalDate periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public LocalDate getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(LocalDate peridoInicial) {
        this.periodoInicial = peridoInicial;
    }

    @Override
    public String toString() {
        return "ExpAnterior{" +
                "descricao='" + descricao + '\'' +
                ", cargo=" + cargo +
                ", periodoFinal=" + periodoFinal +
                ", peridoInicial=" + periodoInicial +
                '}';
    }

    public static class Builder{
        private String descricao;
        private Cargo cargo;
        private LocalDate periodoFinal;
        private LocalDate periodoInicial;
        private Funcionario funcionario;

        private Builder(){

        }

        public static Builder create(){
            return new Builder();
        }

        public static Builder from(ExperienciaAnterior experienciaAnterior){
            Builder builder = new Builder();

            builder.descricao = experienciaAnterior.descricao;
            builder.cargo = experienciaAnterior.cargo;
            builder.periodoFinal = experienciaAnterior.periodoFinal;
            builder.periodoInicial = experienciaAnterior.periodoInicial;
            builder.funcionario = experienciaAnterior.funcionario;

            return builder;
        }

        public Builder descricao(String descricao){
            this.descricao = descricao;
            return this;
        }

        public Builder cargo(Cargo cargo){
            this.cargo = cargo;
            return this;
        }

        public Builder periodoFinal(LocalDate periodoFinal){
            this.periodoFinal = periodoFinal;
            return this;
        }

        public Builder periodoInicial(LocalDate periodoInicial){
            this.periodoInicial = periodoInicial;
            return this;
        }

        public Builder funcionario(Funcionario funcionario){
            this.funcionario = funcionario;
            return this;
        }

        public ExperienciaAnterior build(){
            return new ExperienciaAnterior(descricao, cargo, periodoFinal, periodoInicial, funcionario);
        }
    }
}