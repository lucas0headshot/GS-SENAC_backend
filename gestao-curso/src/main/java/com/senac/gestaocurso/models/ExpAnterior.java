package com.senac.gestaocurso.models;



import jakarta.persistence.Entity;
import java.time.LocalDate;



@Entity
public class ExpAnterior {
    private String descricao;
    private Cargo cargo;
    private LocalDate periodoFinal;
    private LocalDate peridoInicial;



    public ExpAnterior() {
    }



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public LocalDate getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(LocalDate periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public LocalDate getPeridoInicial() {
        return peridoInicial;
    }

    public void setPeridoInicial(LocalDate peridoInicial) {
        this.peridoInicial = peridoInicial;
    }

    @Override
    public String toString() {
        return "ExpAnterior{" +
                "descricao='" + descricao + '\'' +
                ", cargo=" + cargo +
                ", periodoFinal=" + periodoFinal +
                ", peridoInicial=" + peridoInicial +
                '}';
    }
}
