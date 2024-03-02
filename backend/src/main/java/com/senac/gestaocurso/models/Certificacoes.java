package com.senac.gestaocurso.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;



import java.time.LocalDate;



@Entity
public class Certificacoes extends EntityID {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @Column(nullable = false)
    private LocalDate dataEmissao;



    public Certificacoes() {
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