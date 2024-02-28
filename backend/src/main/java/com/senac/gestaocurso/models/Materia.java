package com.senac.gestaocurso.models;



import jakarta.persistence.Entity;



@Entity
public class Materia extends EntityID {
    private String nome;
    private Integer cargaHoraria;
    private Funcionario nomeProfessor;



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

    public Funcionario getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(Funcionario nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }



    @Override
    public String toString() {
        return "Materia{" +
                "nomeDaMateria='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", nomeProfessor=" + nomeProfessor +
                '}';
    }
}
