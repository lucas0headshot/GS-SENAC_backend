package com.senac.gestaocurso.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.List;



@Entity
public class Turma extends EntityID {
    @ManyToOne
    private Curso curso;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private List<Funcionario> alunos;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFinal;



    public Turma() {
    }



    public String getNomeTurma() {
        return nome;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nome = nomeTurma;
    }

    public List<Funcionario> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Funcionario> alunos) {
        this.alunos = alunos;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }



    @Override
    public String toString() {
        return "Turma{" +
                "nomeTurma='" + nome + '\'' +
                ", alunos=" + alunos +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                '}';
    }
}