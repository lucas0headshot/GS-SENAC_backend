package com.senac.gestaocurso.models.domain;



import com.senac.gestaocurso.models.EntityID;
import com.senac.gestaocurso.models.Funcionario;
import jakarta.persistence.*;

import java.time.LocalDate;



@Entity
public class Aula extends EntityID {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "materia_id")
    private Materia materia;

    @Column(nullable = false)
    private LocalDate dia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private Funcionario professor;



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
}
