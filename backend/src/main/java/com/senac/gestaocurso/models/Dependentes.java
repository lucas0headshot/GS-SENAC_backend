package com.senac.gestaocurso.models;



import com.senac.gestaocurso.enums.Escolaridade;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;



@Entity
public class Dependentes extends EntityID {
    @Column
    private String nome;

    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    @Column
    private LocalDate dataNasc;



    public Dependentes() {
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }



    @Override
    public String toString() {
        return "Dependentes{" +
                "nome='" + nome + '\'' +
                ", escolaridade=" + escolaridade +
                ", dataNasc=" + dataNasc +
                '}';
    }
}