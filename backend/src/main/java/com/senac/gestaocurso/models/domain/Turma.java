package com.senac.gestaocurso.models.domain;

import com.senac.gestaocurso.models.EntityID;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turma extends EntityID {

    @ManyToOne
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
    private List<Inscricao> inscritos;

    @Column
    private Integer limiteQtdInscricao;

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

    public Integer getLimiteQtdInscricao() {
        return limiteQtdInscricao;
    }

    public void setLimiteQtdInscricao(Integer limiteQtdInscricao) {
        this.limiteQtdInscricao = limiteQtdInscricao;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "curso=" + curso +
                ", nome='" + nome + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", descricao='" + descricao + '\'' +
                ", inscritos=" + inscritos +
                ", limiteQtdInscricao=" + limiteQtdInscricao +
                '}';
    }
}
