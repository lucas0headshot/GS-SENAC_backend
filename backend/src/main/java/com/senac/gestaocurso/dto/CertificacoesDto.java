package com.senac.gestaocurso.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class CertificacoesDto implements Serializable {
    private final Long id;
    private final String nome;
    private final Integer cargaHoraria;
    private final LocalDate dataEmissao;

    public CertificacoesDto(Long id, String nome, Integer cargaHoraria, LocalDate dataEmissao) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.dataEmissao = dataEmissao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificacoesDto entity = (CertificacoesDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.cargaHoraria, entity.cargaHoraria) &&
                Objects.equals(this.dataEmissao, entity.dataEmissao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cargaHoraria, dataEmissao);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ", " +
                "cargaHoraria = " + cargaHoraria + ", " +
                "dataEmissao = " + dataEmissao + ")";
    }
}