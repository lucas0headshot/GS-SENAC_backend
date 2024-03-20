package com.senac.gestaocurso.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;



@Entity
public class ExpAnterior extends EntityID {
    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @Column(nullable = false)
    private LocalDate periodoFinal;

    @Column(nullable = false)
    private LocalDate peridoInicial;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;



    public ExpAnterior() {
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

    public LocalDate getPeridoInicial() {
        return peridoInicial;
    }

    public void setPeridoInicial(LocalDate peridoInicial) {
        this.peridoInicial = peridoInicial;
    }



    @Override
    public String toString() {
        return "ExpAnterior{" +
                "descricao='" + descricao + '\'' +
                ", cargo=" + cargo +
                ", periodoFinal=" + periodoFinal +
                ", peridoInicial=" + peridoInicial +
                '}';
    }
}