package com.senac.gestaocurso.models.domain;

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

    public Inscricao(Builder builder) {
        this.inscrito = builder.inscrito;
        this.data = builder.data;
        this.status = builder.status;
        this.valor = builder.valor;
        this.curso = builder.curso;
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

    public static class Builder {
        private Funcionario inscrito;
        private LocalDate data;
        private StatusInscricao status;
        private Integer valor;
        private Curso curso;

        public Builder() {

        }

        public static Builder builder() {
            return new Builder();
        }

        public Funcionario funcionario(Funcionario inscrito) {
            this.inscrito = inscrito;
            return this.inscrito;
        }

        public Builder data(LocalDate data) {
            this.data = data;
            return this;
        }

        public Builder status(StatusInscricao status) {
            this.status = status;
            return this;
        }

        public Builder valor(Integer valor) {
            this.valor = valor;
            return this;
        }

        public Builder curso(Curso curso) {
            this.curso = curso;
            return this;
        }

        public Inscricao build() {
            return new Inscricao(this);
        }
    }
}
