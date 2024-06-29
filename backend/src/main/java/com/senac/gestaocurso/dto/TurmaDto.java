package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.domain.Turma;
import java.time.LocalDate;

public class TurmaDto {
    private  String nome;
    private  LocalDate dataInicio;
    private  LocalDate dataFinal;
    private  String descricao;
    private  Integer limiteQtdInscricao;

    public TurmaDto() {}

    public TurmaDto(String nome, LocalDate dataInicio, LocalDate dataFinal, String descricao, Integer limiteQtdInscricao) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.descricao = descricao;
        this.limiteQtdInscricao = limiteQtdInscricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getLimiteQtdInscricao() {
        return limiteQtdInscricao;
    }

    public void setLimiteQtdInscricao(Integer limiteQtdInscricao) {
        this.limiteQtdInscricao = limiteQtdInscricao;
    }


    public static TurmaDto fromEntity(Turma entity){
        return new TurmaDto(
            entity.getNome(),
            entity.getDataInicio(),
            entity.getDataFinal(),
            entity.getDescricao(),
            entity.getLimiteQtdInscricao()
        );
    }

    public Turma toEntity(){
        Turma entity = new Turma();
        entity.setNome(this.nome);
        entity.setDataInicio(this.dataInicio);
        entity.setDataFinal(this.dataFinal);
        entity.setDescricao(this.descricao);
        entity.setLimiteQtdInscricao(this.limiteQtdInscricao);
        return entity;
    }
}
