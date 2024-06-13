package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.ExperienciaAnterior;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class ExpAnteriorDto  {
    private  Long id;
    private  String descricao;
    private  LocalDate periodoFinal;
    private  LocalDate periodoInicial;

    public ExpAnteriorDto(Long id, String descricao, LocalDate periodoFinal, LocalDate periodoInicial) {
        this.id = id;
        this.descricao = descricao;
        this.periodoFinal = periodoFinal;
        this.periodoInicial = periodoInicial;
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

    public LocalDate getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(LocalDate periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public LocalDate getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(LocalDate periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public static ExpAnteriorDto fromEntityList(ExperienciaAnterior entity){
        return new ExpAnteriorDto(

                entity.getId(),
                entity.getDescricao(),
                entity.getPeriodoInicial(),
                entity.getPeriodoFinal()
        );
    }

    public ExperienciaAnterior toEntity(){

        ExperienciaAnterior entity = new ExperienciaAnterior();
                entity.setId(this.id);
                entity.setDescricao(this.descricao);
                entity.setPeriodoInicial(this.periodoInicial);
                entity.setPeriodoFinal(this.periodoFinal);
                return entity;

    }
}