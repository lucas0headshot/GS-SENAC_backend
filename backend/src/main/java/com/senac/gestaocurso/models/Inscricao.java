package com.senac.gestaocurso.models;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.senac.gestaocurso.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;



@Entity
public class Inscricao extends EntityID {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inscrito_id")
    private Funcionario inscrito;

    @Column
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private Integer valor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "turma_id")
    private Turma turma;


    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }


    public Inscricao() {
    }


    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Funcionario getInscrito() {
        return inscrito;
    }

    public void setInscrito(Funcionario inscrito) {
        this.inscrito = inscrito;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }



    @Override
    public String toString() {
        return "Inscricao{" +
                "inscrito=" + inscrito +
                ", data=" + data +
                ", status=" + status +
                ", valor=" + valor +
                '}';
    }
}