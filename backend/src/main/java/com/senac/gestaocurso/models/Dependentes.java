package com.senac.gestaocurso.models;



import com.senac.gestaocurso.enums.Escolaridade;
import jakarta.persistence.*;

import java.time.LocalDate;



@Entity
public class Dependentes extends EntityID {
    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    @Column(nullable = false)
    private LocalDate dataNasc;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;



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