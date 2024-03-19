package com.senac.gestaocurso.models;



import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
public class Chamada extends EntityID {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private Funcionario professor;

    @OneToMany(mappedBy = "chamada", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Frequencia> frequencias = new ArrayList<>();



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
