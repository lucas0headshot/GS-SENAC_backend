package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.models.domain.Aula;
import com.senac.gestaocurso.models.domain.Materia;

import java.time.LocalDate;

public class AulaDto {
    private  Long id;
    private Materia materia;
    private  LocalDate dia;
    private Funcionario professor;


    public AulaDto() {}

    public AulaDto(Long id,Materia materia ,LocalDate dia, Funcionario professor) {
        this.id = id;
        this.materia = materia;
        this.dia = dia;
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Funcionario getProfessor() {
        return professor;
    }

    public void setProfessor(Funcionario professor) {
        this.professor = professor;
    }

    public static AulaDto fromEntity(Aula entity){
            return new AulaDto(
                    entity.getId(),
                    entity.getMateria(),
                    entity.getDia(),
                    entity.getProfessor()
            );
        }

    public Aula toEntity(){
        return Aula.Builder.builder()
                .dia(this.dia)
                .build();
    }
}
