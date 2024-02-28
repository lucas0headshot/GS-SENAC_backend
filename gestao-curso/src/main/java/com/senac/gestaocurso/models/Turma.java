package com.senac.gestaocurso.models;

import java.time.LocalDate;
import java.util.List;

public class Turma {

    private String nome;
    private List<Funcionario> alunos;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private Curso curso;
    private String descricao;

    public Turma() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeTurma) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
