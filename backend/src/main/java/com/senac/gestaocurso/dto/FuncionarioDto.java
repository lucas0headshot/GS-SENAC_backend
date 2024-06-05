package com.senac.gestaocurso.dto;

import java.io.Serializable;
import java.util.Objects;


public class FuncionarioDto implements Serializable {
    private final Long id;
    private final String nome;
    private final String cpf;
    private final String rg;
    private final String endereco;
    private final String ctbs;

    public FuncionarioDto(Long id, String nome, String cpf, String rg, String endereco, String ctbs) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.ctbs = ctbs;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCtbs() {
        return ctbs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuncionarioDto entity = (FuncionarioDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.cpf, entity.cpf) &&
                Objects.equals(this.rg, entity.rg) &&
                Objects.equals(this.endereco, entity.endereco) &&
                Objects.equals(this.ctbs, entity.ctbs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, rg, endereco, ctbs);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ", " +
                "cpf = " + cpf + ", " +
                "rg = " + rg + ", " +
                "endereco = " + endereco + ", " +
                "ctbs = " + ctbs + ")";
    }
}