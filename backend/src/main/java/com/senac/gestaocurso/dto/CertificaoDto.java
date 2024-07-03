package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.domain.Certificacao;
import java.time.LocalDate;

public class CertificaoDto {
    private  Long id;
    private  String nome;
    private  Integer cargaHoraria;
    private  LocalDate dataEmissao;

    public CertificaoDto(){

    }

    public CertificaoDto(Long id, String nome, Integer cargaHoraria, LocalDate dataEmissao) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.dataEmissao = dataEmissao;
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

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public static CertificaoDto fromEntity(Certificacao entity){
        return new CertificaoDto(
            entity.getId(),
            entity.getNome(),
            entity.getCargaHoraria(),
            entity.getDataEmissao()
        );
    }
    public Certificacao toEntity(){
        Certificacao entity = new Certificacao();
        entity.setId(this.id);
        entity.setNome(this.nome);
        entity.setCargaHoraria(this.cargaHoraria);
        entity.setDataEmissao(this.dataEmissao);
        return  entity;
    }
}
