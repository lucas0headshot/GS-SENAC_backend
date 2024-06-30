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
}
