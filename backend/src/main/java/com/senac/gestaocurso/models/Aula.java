package com.senac.gestaocurso.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;


@Entity
public class Aula extends EntityID {
    @Column(nullable = false)
    private Materia materia;

    @Column(nullable = false)
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
