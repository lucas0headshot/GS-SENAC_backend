package com.senac.gestaocurso.models;



import jakarta.persistence.*;

import java.util.List;



@Entity
public class Chamada extends EntityID {
    @Column()
    private Funcionario professor;

    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL)
    private List<Frequencia> frequencias;



    public Chamada() {}


    public Funcionario getProfessor() {
        return professor;
    }

    public void setProfessor(Funcionario professor) {
        this.professor = professor;
    }

    public List<Frequencia> getFrequencias() {
        return frequencias;
    }

    public void setFrequencias(List<Frequencia> frequencias) {
        this.frequencias = frequencias;
    }


    @Override
    public String toString() {
        return "Chamada{" +
                "professor=" + professor +
                ", frequencias=" + frequencias +
                '}';
    }
}
