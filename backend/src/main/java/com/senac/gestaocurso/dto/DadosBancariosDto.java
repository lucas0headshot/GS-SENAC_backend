package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.enums.TipoContaBancaria;
import com.senac.gestaocurso.models.DadosBancario;

import java.io.Serializable;
import java.util.Objects;


public class DadosBancariosDto {
    private  String banco;
    private  String agencia;
    private  String conta;
    private  TipoContaBancaria tipoContaBancaria;

    public DadosBancariosDto(){}

    public DadosBancariosDto(String banco, String agencia, String conta, TipoContaBancaria tipoContaBancaria) {
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.tipoContaBancaria = tipoContaBancaria;
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

    public static DadosBancariosDto fromEntityList (DadosBancario entity){
        return new DadosBancariosDto(

                entity.getBanco(),
                entity.getAgencia(),
                entity.getConta(),
                entity.getTipoContaBancaria()
        );
    }

    public DadosBancario toEntity(){

        DadosBancario entity = new DadosBancario();

                entity.setBanco(this.banco);
                entity.setAgencia(this.agencia);
                entity.setConta(this.conta);
                entity.setTipoContaBancaria(this.tipoContaBancaria);
                return entity;
    }
}