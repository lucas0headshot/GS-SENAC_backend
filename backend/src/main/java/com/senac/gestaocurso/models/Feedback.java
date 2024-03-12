package com.senac.gestaocurso.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;


@Entity
public class Feedback extends EntityID {
    @Column(nullable = false)
    private Funcionario autor;

    @Column
    private String feedback;

    @Column(nullable = false)
    private Integer nota;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Object avaliado;


    public Funcionario getAutor() {
        return autor;
    }

    public void setAutor(Funcionario autor) {
        this.autor = autor;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Object getAvaliado() {
        return avaliado;
    }

    public void setAvaliado(Object avaliado) {
        this.avaliado = avaliado;
    }



    @Override
    public String toString() {
        return "Feedback{" +
                "autor=" + autor +
                ", feedback='" + feedback + '\'' +
                ", nota=" + nota +
                ", data=" + data +
                ", avaliado=" + avaliado +
                '}';
    }
}