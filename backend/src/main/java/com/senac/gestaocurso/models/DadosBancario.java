package com.senac.gestaocurso.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.gestaocurso.enums.TipoContaBancaria;
import jakarta.persistence.*;


@Entity
public class DadosBancario extends EntityID {
    @Column(nullable = false)
    private String banco;

    @Column(nullable = false)
    private String agencia;

    @Column(nullable = false)
    private String conta;

    @Enumerated(EnumType.STRING)
    private TipoContaBancaria tipoContaBancaria;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id")
    @JsonIgnore
    private Funcionario funcionario;



    public DadosBancario() {
    }

    public DadosBancario(String banco, String agencia, String conta, TipoContaBancaria tipoContaBancaria, Funcionario funcionario) {
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.tipoContaBancaria = tipoContaBancaria;
        this.funcionario = funcionario;
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

    public static class Builder{
        private String banco;
        private String agencia;
        private String conta;
        private TipoContaBancaria tipoContaBancaria;
        private Funcionario funcionario;

        private Builder(){

        }

        public static Builder create(){
            return new Builder();
        }

        public static Builder from(DadosBancario dadosBancario){
            Builder builder = new Builder();

            builder.agencia = dadosBancario.agencia;
            builder.banco = dadosBancario.banco;
            builder.conta = dadosBancario.conta;
            builder.funcionario = dadosBancario.funcionario;
            builder.tipoContaBancaria = dadosBancario.tipoContaBancaria;

            return builder;
        }

        public Builder agencia(String agencia){
            this.agencia = agencia;
            return this;
        }

        public Builder banco(String banco){
            this.banco = banco;
            return this;
        }

        public Builder conta(String conta){
            this.conta = conta;
            return this;
        }

        public Builder funcionario(Funcionario funcionario){
            this.funcionario = funcionario;
            return this;
        }

        public Builder tipoContaBancaria(TipoContaBancaria tipoContaBancaria){
            this.tipoContaBancaria = tipoContaBancaria;
            return this;
        }

        public DadosBancario build(){
            return new DadosBancario(agencia, banco, conta, tipoContaBancaria, funcionario);
        }
    }
}