package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.enums.TipoContaBancaria;

import java.io.Serializable;
import java.util.Objects;


public class DadosBancariosDto implements Serializable {
    private final String banco;
    private final String agencia;
    private final String conta;
    private final TipoContaBancaria tipoContaBancaria;

    public DadosBancariosDto(String banco, String agencia, String conta, TipoContaBancaria tipoContaBancaria) {
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.tipoContaBancaria = tipoContaBancaria;
    }

    public String getBanco() {
        return banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getConta() {
        return conta;
    }

    public TipoContaBancaria getTipoContaBancaria() {
        return tipoContaBancaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DadosBancariosDto entity = (DadosBancariosDto) o;
        return Objects.equals(this.banco, entity.banco) &&
                Objects.equals(this.agencia, entity.agencia) &&
                Objects.equals(this.conta, entity.conta) &&
                Objects.equals(this.tipoContaBancaria, entity.tipoContaBancaria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(banco, agencia, conta, tipoContaBancaria);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "banco = " + banco + ", " +
                "agencia = " + agencia + ", " +
                "conta = " + conta + ", " +
                "tipoContaBancaria = " + tipoContaBancaria + ")";
    }
}