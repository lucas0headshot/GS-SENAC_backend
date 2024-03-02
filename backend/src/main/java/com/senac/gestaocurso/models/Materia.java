package com.senac.gestaocurso.models;



import jakarta.persistence.*;


@Entity
public class Materia extends EntityID {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Funcionario professor;



    public Materia() {
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Funcionario getProfessor() {
        return professor;
    }

    public void setProfessor(Funcionario professor) {
        this.professor = professor;
    }



    @Override
    public String toString() {
        return "Materia{" +
                "nomeDaMateria='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", professor=" + professor +
                '}';
    }
}