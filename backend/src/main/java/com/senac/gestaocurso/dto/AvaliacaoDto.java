package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.domain.Avaliacao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class AvaliacaoDto   {
    private  Long id;
    private  String nome;
    private  Integer nota;
    private  LocalDate data;

    public AvaliacaoDto(){

    }
    public AvaliacaoDto(Long id, String nome, Integer nota, LocalDate data) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public static AvaliacaoDto fromEntity (Avaliacao entity){
        return new AvaliacaoDto(

                entity.getId(),
                entity.getNome(),
                entity.getNota(),
                entity.getData()
        );
    }

    public Avaliacao toEntity(){
        Avaliacao entity = new Avaliacao();

        entity.setId(this.id);
        entity.setNome(this.nome);
        entity.setNota(this.nota);
        entity.setData(this.data);
        return  entity;
    }
}