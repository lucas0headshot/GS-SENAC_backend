package com.senac.gestaocurso.models;



import jakarta.persistence.Entity;



@Entity
public class Frequencia extends EntityID {
    private Boolean frequencia;
    private Aula aula;
    private Funcionario aluno;



    public Frequencia() {
    }



    public Boolean getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Boolean frequencia) {
        this.frequencia = frequencia;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Funcionario getAluno() {
        return aluno;
    }

    public void setAluno(Funcionario aluno) {
        this.aluno = aluno;
    }



    @Override
    public String toString() {
        return "Frequencia{" +
                "frequencia=" + frequencia +
                ", aula=" + aula +
                ", aluno=" + aluno +
                '}';
    }
}