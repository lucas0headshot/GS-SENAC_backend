package com.senac.gestaocurso.models.domain;

import com.senac.gestaocurso.models.EntityID;
import jakarta.persistence.*;

@Entity
public class Frequencia extends EntityID {
    @Column(nullable = false)
    private Boolean frequencia;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "inscricao_id")
    private Inscricao aluno;

    public Frequencia() {
    }

    public Frequencia(Builder builder) {
        this.frequencia = builder.frequencia;
        this.aula = builder.aula;
        this.aluno = builder.aluno;
    }

    public Boolean getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Boolean frequencia) {
        this.frequencia = frequencia;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Inscricao getInscricao() {
        return aluno;
    }

    public void setInscricao(Inscricao inscricao) {
        this.aluno = inscricao;
    }

    @Override
    public String toString() {
        return "Frequencia{" +
                "frequencia=" + frequencia +
                ", aula=" + aula +
                ", aluno=" + aluno +
                '}';
    }

    public static class Builder {
        private Boolean frequencia;
        private Aula aula;
        private Inscricao aluno;

        public Builder frequencia(Boolean frequencia) {
            this.frequencia = frequencia;
            return this;
        }

        public Builder aula(Aula aula) {
            this.aula = aula;
            return this;
        }

        public Builder aluno(Inscricao aluno) {
            this.aluno = aluno;
            return this;
        }

        public Frequencia build() {
            return new Frequencia(this);
        }
    }
}
