package com.senac.gestaocurso.models.domain;

import com.senac.gestaocurso.models.Chamada;
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

    @ManyToOne
    @JoinColumn(name = "chamada_id")
    private Chamada chamada;

    public Frequencia() {
    }

    public Chamada getChamada() {
        return chamada;
    }

    public void setChamada(Chamada chamada) {
        this.chamada = chamada;
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
}
