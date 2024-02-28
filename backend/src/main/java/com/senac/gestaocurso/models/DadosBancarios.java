package com.senac.gestaocurso.models;



import com.senac.gestaocurso.enums.TipoContaBancaria;
import jakarta.persistence.Entity;



@Entity
public class DadosBancarios {
    private String banco;
    private String agencia;
    private String conta;
    private TipoContaBancaria tipoContaBancaria;



    public DadosBancarios() {
    }



    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public TipoContaBancaria getTipoContaBancaria() {
        return tipoContaBancaria;
    }

    public void setTipoContaBancaria(TipoContaBancaria tipoContaBancaria) {
        this.tipoContaBancaria = tipoContaBancaria;
    }


    @Override
    public String toString() {
        return "DadosBancarios{" +
                "banco='" + banco + '\'' +
                ", agencia='" + agencia + '\'' +
                ", conta='" + conta + '\'' +
                ", tipoContaBancaria=" + tipoContaBancaria +
                '}';
    }
}
