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
}
