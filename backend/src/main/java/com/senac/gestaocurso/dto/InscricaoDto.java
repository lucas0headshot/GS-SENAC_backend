package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.enums.StatusInscricao;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.models.domain.Curso;
import com.senac.gestaocurso.models.domain.Inscricao;
import java.time.LocalDate;

public class InscricaoDto {
    private Long id;
    private  LocalDate data;
    private StatusInscricao status;
    private  Integer valor;
    private Funcionario funcionario;
    private Curso curso;

    public InscricaoDto(){}

    public InscricaoDto(Long id, LocalDate data, StatusInscricao status, Integer valor, Funcionario funcionario, Curso curso) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.valor = valor;
        this.funcionario = funcionario;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public static InscricaoDto fromEntity(Inscricao entity){
        return new InscricaoDto(
            entity.getId(),
            entity.getData(),
            entity.getStatus(),
            entity.getValor(),
            entity.getInscrito(),
            entity.getCurso());
    }

    public Inscricao toEntity(){
        return Inscricao.Builder.builder()
                .inscrito(this.funcionario)
                .data(this.data)
                .status(this.status)
                .valor(this.valor)
                .build();
    }
}
