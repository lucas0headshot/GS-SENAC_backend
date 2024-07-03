package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.enums.Escolaridade;
import com.senac.gestaocurso.models.Dependente;
import java.time.LocalDate;

public class DependenteDto {
    private  String nome;
    private  Escolaridade escolaridade;
    private  LocalDate dataNasc;

    public DependenteDto(){}

    public DependenteDto(String nome, Escolaridade escolaridade, LocalDate dataNasc) {
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

    public static DependenteDto fromEntity(Dependente entity){
        return new DependenteDto(
            entity.getNome(),
            entity.getEscolaridade(),
            entity.getDataNasc()
        );
    }

    public Dependente toEntity(){
        Dependente entity = new Dependente();
        entity.setNome(this.nome);
        entity.setEscolaridade(this.escolaridade);
        entity.setDataNasc(this.dataNasc);
        return entity;
    }
}
