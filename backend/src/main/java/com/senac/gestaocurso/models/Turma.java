package com.senac.gestaocurso.models;



import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;



@Entity
public class Turma extends EntityID {
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Column(nullable = false)
    private String nome;

    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL)
    private List<Inscricao> inscritos;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFinal;

    @Column(nullable = false)
    private String descricao;



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