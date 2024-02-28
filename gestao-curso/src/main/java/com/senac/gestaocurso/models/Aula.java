package com.senac.gestaocurso.models;

import java.time.LocalDate;

public class Aula {
    private Materia materia;
    private LocalDate diaDaAula;

    public Aula() {
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public LocalDate getDiaDaAula() {
        return diaDaAula;
    }

    public void setDiaDaAula(LocalDate diaDaAula) {
        this.diaDaAula = diaDaAula;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "materia=" + materia +
                ", diaDaAula=" + diaDaAula +
                '}';
    }
}
