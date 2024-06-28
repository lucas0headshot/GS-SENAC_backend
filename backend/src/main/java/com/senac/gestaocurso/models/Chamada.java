package com.senac.gestaocurso.models;



import com.senac.gestaocurso.models.domain.Frequencia;
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



    public Chamada() {

    }

    public Chamada(Funcionario professor, List<Frequencia> frequencias) {
        this.professor = professor;
        this.frequencias = frequencias;
    }

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

    public static class Builder{
        private Funcionario professor;

        private List<Frequencia> frequencias = new ArrayList<>();

        private Builder(){

        }
        public static Builder create(){
            return new Builder();
        }

        public static Builder from(Chamada chamada){
            Builder builder = new Builder();

            builder.professor = chamada.professor;
            builder.frequencias = chamada.frequencias;

            return builder;
        }

        public Builder professor(Funcionario professor){
            this.professor = professor;
            return this;
        }

        public Builder frequencias(List<Frequencia> frequencias){
            this.frequencias = frequencias;
            return this;
        }

        public Chamada build(){
            return new Chamada(professor, frequencias);
        }
    }
}
