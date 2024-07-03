package com.senac.gestaocurso.models.domain;

import com.senac.gestaocurso.models.EntityID;
import com.senac.gestaocurso.models.Funcionario;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso extends EntityID {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "coordenador_id")
    private Funcionario coordenador;

    @Column(nullable = false)
    private Integer cargaHorariaTotal;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataInicioInscricao;

    @Column(nullable = false)
    private LocalDate dataFinal;

    @Column(nullable = false)
    private LocalDate dataFinalInscricao;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscricao> inscritos = new ArrayList<>();

    @Column(nullable = false)
    private Integer limiteQtdInscricao;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Materia> materias = new ArrayList<>();

    public Curso() {
    }

    public Curso(Builder builder) {
        this.nome = builder.nome;
        this.descricao = builder.descricao;
        this.coordenador = builder.coordenador;
        this.cargaHorariaTotal = builder.cargaHorariaTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataInicioInscricao() {
        return dataInicioInscricao;
    }

    public void setDataInicioInscricao(LocalDate dataInicioInscricao) {
        this.dataInicioInscricao = dataInicioInscricao;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public LocalDate getDataFinalInscricao() {
        return dataFinalInscricao;
    }

    public void setDataFinalInscricao(LocalDate dataFinalInscricao) {
        this.dataFinalInscricao = dataFinalInscricao;
    }

    public List<Inscricao> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<Inscricao> inscritos) {
        this.inscritos = inscritos;
    }

    public Integer getLimiteQtdInscricao() {
        return limiteQtdInscricao;
    }

    public void setLimiteQtdInscricao(Integer limiteQtdInscricao) {
        this.limiteQtdInscricao = limiteQtdInscricao;
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
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", coordenador=" + coordenador +
                ", cargaHorariaTotal=" + cargaHorariaTotal +
                ", dataInicio=" + dataInicio +
                ", dataInicioInscricao=" + dataInicioInscricao +
                ", dataFinal=" + dataFinal +
                ", dataFinalInscricao=" + dataFinalInscricao +
                ", inscritos=" + inscritos +
                ", limiteQtdInscricao=" + limiteQtdInscricao +
                ", materias=" + materias +
                '}';
    }

    public static class Builder {
        private String nome;
        private String descricao;
        private Funcionario coordenador;
        private Integer cargaHorariaTotal;

        public Builder(){
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder descricao(String descricao){
            this.descricao = descricao;
            return this;
        }

        public Builder coordenador(Funcionario coordenador){
            this.coordenador = coordenador;
            return this;
        }

        public Builder cargaHorariaTotal(Integer cargaHorariaTotal){
            this.cargaHorariaTotal = cargaHorariaTotal;
            return this;
        }

        public Curso build(){
            return new Curso(this);
        }
    }
}