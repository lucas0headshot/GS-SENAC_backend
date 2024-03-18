package com.senac.gestaocurso.models;



import jakarta.persistence.*;

import java.time.LocalDate;



@Entity
public class Aula extends EntityID {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "materia_id")
    private Materia materia;

    private LocalDate dia;



    public Aula(){}



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



    @Override
    public String toString() {
        return "Aula{" +
                "materia=" + materia +
                ", dia=" + dia +
                '}';
    }
}
