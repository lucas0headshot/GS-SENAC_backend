package com.senac.gestaocurso.models;

import jakarta.persistence.Entity;



import java.util.List;



@Entity
public class Curso {
    private String nomeCurso;
    private Funcionario coordenador;
    private Integer cargaHorariaTotal;
    private List<Materia> materias;


    public Curso() {
    }



    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Funcionario getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Funcionario coordenador) {
        this.coordenador = coordenador;
    }

    public Integer getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(Integer cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }



    @Override
    public String toString() {
        return "Curso{" +
                "nomeCurso='" + nomeCurso + '\'' +
                ", coordenador=" + coordenador +
                ", cargaHorariaTotal=" + cargaHorariaTotal +
                ", materias=" + materias +
                '}';
    }
}