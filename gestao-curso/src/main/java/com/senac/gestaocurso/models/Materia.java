package com.senac.gestaocurso.models;

import com.senac.gestaocurso.enums.DiaDaSemana;

public class Materia {

    private String nomeDaMateria;
    private Integer cargaHoraria;
    private Funcionario nomeProfessor;
    private DiaDaSemana diaDaSemana;

    public Materia() {
    }

    public String getNomeDaMateria() {
        return nomeDaMateria;
    }

    public void setNomeDaMateria(String nomeDaMateria) {
        this.nomeDaMateria = nomeDaMateria;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Funcionario getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(Funcionario nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public DiaDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nomeDaMateria='" + nomeDaMateria + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", nomeProfessor=" + nomeProfessor +
                ", diaDaSemana=" + diaDaSemana +
                '}';
    }
}
