package com.senac.gestaocurso.models;



import jakarta.persistence.*;

import java.time.LocalDate;



@Entity
public class Avaliacao extends EntityID {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "materia_id")
    private Materia materia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Inscricao aluno;

    @Column(nullable = false)
    private String nome;

    @Column
    private Integer nota;

    @Column(nullable = false)
    private LocalDate data;



    public Avaliacao() {
    }





    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Inscricao getAluno() {
        return aluno;
    }

    public void setAluno(Inscricao aluno) {
        this.aluno = aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }



    @Override
    public String toString() {
        return "Avaliacao{" +
                "aluno=" + aluno +
                ", materia=" + materia +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", data=" + data +
                '}';
    }
}