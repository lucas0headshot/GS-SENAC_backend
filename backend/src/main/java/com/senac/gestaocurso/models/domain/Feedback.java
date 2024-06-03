package com.senac.gestaocurso.models.domain;


import com.senac.gestaocurso.models.EntityID;
import com.senac.gestaocurso.models.Funcionario;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Feedback extends EntityID {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Funcionario autor;

    @Column(nullable = false)
    private String feedback;

    @Column(nullable = false)
    private Integer nota;

    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avaliado_id")
    private Curso avaliado;


    public Feedback() {

    }




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

    public void setAvaliado(Curso avaliado) {
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