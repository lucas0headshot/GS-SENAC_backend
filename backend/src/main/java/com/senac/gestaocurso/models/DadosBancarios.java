package com.senac.gestaocurso.models;



import com.senac.gestaocurso.enums.TipoContaBancaria;
import jakarta.persistence.*;


@Entity
public class DadosBancarios extends EntityID {
    @Column(nullable = false)
    private String banco;

    @Column(nullable = false)
    private String agencia;

    @Column(nullable = false)
    private String conta;

    @Enumerated(EnumType.STRING)
    private TipoContaBancaria tipoContaBancaria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;



    public DadosBancarios() {
    }


    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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