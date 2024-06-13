package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.domain.Materia;

import java.io.Serializable;
import java.util.Objects;


public class MateriaDto {
    private  String nome;
    private  Integer cargaHoraria;

    public MateriaDto(){}

    public MateriaDto(String nome, Integer cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public static MateriaDto fromEntityList(Materia entity){
        return new MateriaDto(

                entity.getNome(),
                entity.getCargaHoraria()
        );
    }

    public Materia toEntity(){

        Materia entity = new Materia();

                entity.setNome(this.nome);
                entity.setCargaHoraria(this.cargaHoraria);
                return entity;
    }
}