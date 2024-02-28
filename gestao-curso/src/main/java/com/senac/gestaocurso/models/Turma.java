package com.senac.gestaocurso.models;

import java.time.LocalDate;
import java.util.List;

public class Turma {

    private String nomeTurma;
    private List<Funcionario> alunos;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public Turma() {
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
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
                "nomeTurma='" + nomeTurma + '\'' +
                ", alunos=" + alunos +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                '}';
    }
}
