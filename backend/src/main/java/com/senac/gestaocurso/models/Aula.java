package com.senac.gestaocurso.models;

<<<<<<< Updated upstream
import java.time.LocalDate;

public class Aula {
    private Materia materia;
    private LocalDate diaDaAula;

    public Aula() {
    }
=======


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


>>>>>>> Stashed changes

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

<<<<<<< Updated upstream
    public LocalDate getDiaDaAula() {
        return diaDaAula;
    }

    public void setDiaDaAula(LocalDate diaDaAula) {
        this.diaDaAula = diaDaAula;
    }

=======
    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }


>>>>>>> Stashed changes
    @Override
    public String toString() {
        return "Aula{" +
                "materia=" + materia +
<<<<<<< Updated upstream
                ", diaDaAula=" + diaDaAula +
                '}';
    }
}
=======
                ", dia=" + dia +
                '}';
    }
}
>>>>>>> Stashed changes
