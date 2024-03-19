package com.senac.gestaocurso.models;



import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Turma extends EntityID {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Column
    private String nome;

    @Column
    private LocalDate dataInicio;

    @Column
    private LocalDate dataFinal;

    @Column
    private String descricao;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscricao> inscritos = new ArrayList<>();



    public Turma() {
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nomeTurma) {
        this.nome = nomeTurma;
    }

    public List<Inscricao> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<Inscricao> inscritos) {
        this.inscritos = inscritos;
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
                ", inscritos=" + inscritos +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                '}';
    }
}