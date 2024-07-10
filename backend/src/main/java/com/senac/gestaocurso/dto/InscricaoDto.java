package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.enums.StatusInscricao;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.models.domain.Curso;
import com.senac.gestaocurso.models.domain.Inscricao;
import java.time.LocalDate;

public class InscricaoDto {
    private  LocalDate data;
    private StatusInscricao status;
    private  Integer valor;
    private Funcionario aluno;
    private Curso curso;

    public InscricaoDto(){}

    public InscricaoDto(LocalDate data, StatusInscricao status, Integer valor, Funcionario aluno, Curso curso) {
        this.data = data;
        this.status = status;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public StatusInscricao getStatus() {
        return status;
    }

    public void setStatus(StatusInscricao status) {
        this.status = status;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public static InscricaoDto fromEntity(Inscricao entity){
        return new InscricaoDto(
            entity.getData(),
            entity.getStatus(),
            entity.getValor(),
                entity.getInscrito(),
                entity.getCurso()
        );
    }

    public Inscricao toEntity(){
        return Inscricao.Builder.builder()
                .inscrito(this.aluno)
                .data(this.data)
                .status(this.status)
                .valor(this.valor)
                .curso(this.curso)
                .build();
    }
}
