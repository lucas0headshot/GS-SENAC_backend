package com.senac.gestaocurso.models;



import com.senac.gestaocurso.enums.TipoContaBancaria;
import jakarta.persistence.*;


@Entity
public class DadosBancarios extends EntityID {
    private String banco;

    private String agencia;

    private String conta;

    private TipoContaBancaria tipoContaBancaria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


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