package com.senac.gestaocurso.models;

import jakarta.persistence.*;


import java.time.LocalDate;



@Entity
public class Certificacoes extends EntityID {
    @Column
    private String nome;

    @Column
    private Integer cargaHoraria;

    @Column
    private LocalDate dataEmissao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;



    public Certificacoes() {
    }


    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }



    @Override
    public String toString() {
        return "Certificacoes{" +
                "nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", dataEmissao=" + dataEmissao +
                '}';
    }
}