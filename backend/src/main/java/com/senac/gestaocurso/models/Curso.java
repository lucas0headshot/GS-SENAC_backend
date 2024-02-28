package com.senac.gestaocurso.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;



import java.util.List;



@Entity
<<<<<<< Updated upstream
public class Curso {
    private String nome;
=======
public class Curso extends EntityID {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
>>>>>>> Stashed changes
    private Funcionario coordenador;

    @Column(nullable = false)
    private Integer cargaHorariaTotal;

    @Column(nullable = false)
    private List<Materia> materias;



    public Curso() {
    }
<<<<<<< Updated upstream
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
=======



    public String getNomeCurso() {
        return nome;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nome = nomeCurso;
>>>>>>> Stashed changes
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
                "nomeCurso='" + nome + '\'' +
                ", coordenador=" + coordenador +
                ", cargaHorariaTotal=" + cargaHorariaTotal +
                ", materias=" + materias +
                '}';
    }
}