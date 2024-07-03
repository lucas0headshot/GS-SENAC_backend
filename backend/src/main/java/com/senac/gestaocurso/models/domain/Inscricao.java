package com.senac.gestaocurso.models.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.gestaocurso.enums.Status;
import com.senac.gestaocurso.enums.StatusInscricao;
import com.senac.gestaocurso.models.EntityID;
import com.senac.gestaocurso.models.Funcionario;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Inscricao extends EntityID {
    @ManyToOne
    @JoinColumn(name = "inscrito_id")
    private Funcionario inscrito;

    @Column(nullable = false)
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatusInscricao status;

    @Column(nullable = false)
    private Integer valor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Inscricao() {
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

    public StatusInscricao getStatus() {
        return status;
    }

    public void setStatus(StatusInscricao status) {
        this.status = status;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Inscricao{" +
                "inscrito=" + inscrito +
                ", data=" + data +
                ", status=" + status +
                ", valor=" + valor +
                ", curso=" + curso +
                '}';
    }
}
