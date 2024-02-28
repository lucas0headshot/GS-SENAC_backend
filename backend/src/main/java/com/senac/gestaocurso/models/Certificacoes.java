package com.senac.gestaocurso.models;

import jakarta.persistence.Entity;



import java.time.LocalDate;



@Entity
public class Certificacoes {
    private String nome;
    private Integer cargaHoraria;
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
