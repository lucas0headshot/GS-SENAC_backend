package com.senac.gestaocurso.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDate;



@Entity
public class Avaliacao extends EntityID {
    @Column(nullable = false)
    private Funcionario aluno;

    @Column(nullable = false)
    private Materia materia;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer nota;

    @Column(nullable = false)
    private LocalDate data;



    public Avaliacao() {
    }



    public Funcionario getAluno() {
        return aluno;
    }

    public void setAluno(Funcionario aluno) {
        this.aluno = aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
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