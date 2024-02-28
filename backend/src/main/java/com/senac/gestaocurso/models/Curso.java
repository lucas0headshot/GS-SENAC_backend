package com.senac.gestaocurso.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;



import java.util.List;



@Entity
public class Curso extends EntityID {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Funcionario coordenador;

    @Column(nullable = false)
    private Integer cargaHorariaTotal;

    @Column(nullable = false)
    private List<Materia> materias;



    public Curso() {
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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