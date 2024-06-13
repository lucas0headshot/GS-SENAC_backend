package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.domain.Curso;

import java.io.Serializable;
import java.util.Objects;


public class CursoDto   {

    private  long id;
    private  String nome;
    private  String descricao;
    private  Integer cargaHorariaTotal;


    public CursoDto(){}

    public CursoDto(Long id, String nome, String descricao, Integer cargaHorariaTotal) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(Integer cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static CursoDto fromEntityList(Curso entity){
        return new CursoDto(

                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getCargaHorariaTotal()


        );
    }

    public Curso toEntity(){

        Curso entity = new Curso();

        entity.setId(this.id);
        entity.setNome(this.nome);
        entity.setDescricao(this.descricao);
        entity.setCargaHorariaTotal(this.cargaHorariaTotal);
        return entity;
    }
}