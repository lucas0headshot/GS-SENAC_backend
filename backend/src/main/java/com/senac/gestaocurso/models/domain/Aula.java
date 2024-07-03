package com.senac.gestaocurso.models.domain;

import com.senac.gestaocurso.models.EntityID;
import com.senac.gestaocurso.models.Funcionario;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Aula extends EntityID {
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    @Column(nullable = false)
    private LocalDate dia;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Funcionario professor;

    public Aula() {

    }

    public Aula(Builder builder){
        this.materia = builder.materia;
        this.dia = builder.dia;
        this.professor = builder.professor;
    }


    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public Funcionario getProfessor() {
        return professor;
    }

    public void setProfessor(Funcionario professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "materia=" + materia +
                ", dia=" + dia +
                '}';
    }

    public static class Builder {
        private Materia materia;
        private LocalDate dia;
        private Funcionario professor;

        public Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder materia(Materia materia) {
            this.materia = materia;
            return this;
        }

        public Builder dia(LocalDate dia) {
            this.dia = dia;
            return this;
        }

        public Builder professor(Funcionario professor) {
            this.professor = professor;
            return this;
        }

        public Aula build() {
            return new Aula(this);
        }
    }
}
