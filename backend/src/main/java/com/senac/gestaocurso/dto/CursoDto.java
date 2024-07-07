package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.domain.Curso;

import java.time.LocalDate;

public class CursoDto {
    private  long id;
    private  String nome;
    private  String descricao;
    private  Integer cargaHorariaTotal;
    private LocalDate dataInicio;
    private LocalDate dataInicioInscricao;
    private LocalDate dataFinal;
    private LocalDate dataFinalInscricao;

    public CursoDto(){}

    public CursoDto(Long id, String nome, String descricao, Integer cargaHorariaTotal, LocalDate dataFinal, LocalDate dataInicio, LocalDate dataInicioInscricao, LocalDate dataFinalInscricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHorariaTotal = cargaHorariaTotal;
        this.dataFinal = dataFinal;
        this.dataInicio = dataInicio;
        this.dataInicioInscricao = dataInicioInscricao;
        this.dataFinalInscricao = dataFinalInscricao;
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

    public LocalDate getDataInicioInscricao() {
        return dataInicioInscricao;
    }

    public void setDataInicioInscricao(LocalDate dataInicioInscricao) {
        this.dataInicioInscricao = dataInicioInscricao;
    }

    public LocalDate getDataFinalInscricao() {
        return dataFinalInscricao;
    }

    public void setDataFinalInscricao(LocalDate dataFinalInscricao) {
        this.dataFinalInscricao = dataFinalInscricao;
    }

    public static CursoDto fromEntity(Curso entity){
        return new CursoDto(
            entity.getId(),
            entity.getNome(),
            entity.getDescricao(),
            entity.getCargaHorariaTotal(),
            entity.getDataFinal(),
            entity.getDataInicio(),
            entity.getDataInicioInscricao(),
            entity.getDataFinalInscricao()
        );
    }

    public Curso toEntity(){
        return Curso.Builder.builder()
                .nome(this.nome)
                .descricao(this.descricao)
                .cargaHorariaTotal(this.cargaHorariaTotal)
                .dataInicio(this.dataInicio)
                .dataInicioInscricao(this.dataInicioInscricao)
                .dataFinal(this.dataFinal)
                .dataFinalInscricao(this.dataFinalInscricao)
                .build();
    }
}
