package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.enums.Escolaridade;
import com.senac.gestaocurso.models.Dependente;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class DependentesDto {
    private  String nome;
    private  Escolaridade escolaridade;
    private  LocalDate dataNasc;

    public DependentesDto(){}

    public DependentesDto(String nome, Escolaridade escolaridade, LocalDate dataNasc) {
        this.nome = nome;
        this.escolaridade = escolaridade;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public static DependentesDto fromEntity(Dependente entity){
        return new DependentesDto(

                entity.getNome(),
                entity.getEscolaridade(),
                entity.getDataNasc()

        );
    }

    public Dependente toEntity (){

        Dependente entity = new Dependente();

                entity.setNome(this.nome);
                entity.setEscolaridade(this.escolaridade);
                entity.setDataNasc(this.dataNasc);
                return entity;
    }
}