package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.Cargo;

import java.io.Serializable;
import java.util.Objects;


public class CargoDto   {
    private  Long id;
    private  String descricao;
    private  String nivel;
    private  Boolean comissionado;

    public CargoDto(){}

    public CargoDto(Long id, String descricao, String nivel, Boolean comissionado) {
        this.id = id;
        this.descricao = descricao;
        this.nivel = nivel;
        this.comissionado = comissionado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Boolean getComissionado() {
        return comissionado;
    }

    public void setComissionado(Boolean comissionado) {
        this.comissionado = comissionado;
    }

    public static CargoDto fromEntity(Cargo entity){
        return new CargoDto(

                entity.getId(),
                entity.getDescricao(),
                entity.getNivel(),
                entity.getComissionado()
        );
    }

    public Cargo toEntity(){

        Cargo entity = new Cargo();

        entity.setId(this.id);
        entity.setDescricao(this.descricao);
        entity.setNivel(this.nivel);
        entity.setComissionado(this.comissionado);

        return  entity;
    }
}