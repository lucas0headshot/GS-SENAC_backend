package com.senac.gestaocurso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.time.LocalDate;



@Entity
public class Certificacoes extends EntityID {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @Column(nullable = false)
    private LocalDate dataEmissao;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id")
    @JsonIgnore
    private Funcionario funcionario;



    public Certificacoes() {
    }

    public Certificacoes(String nome, Integer cargaHoraria, LocalDate dataEmissao, Funcionario funcionario) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.dataEmissao = dataEmissao;
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }



    @Override
    public String toString() {
        return "Certificacoes{" +
                "nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", dataEmissao=" + dataEmissao +
                '}';
    }
}