package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.Funcionario;

public class FuncionarioDto {
    private  Long id;
    private  String nome;
    private  String cpf;
    private  String rg;
    private  String endereco;
    private  String ctbs;


    public FuncionarioDto() {

    }

    public FuncionarioDto(Long id, String nome, String cpf, String rg, String endereco, String ctbs) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.ctbs = ctbs;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCtbs() {
        return ctbs;
    }

    public void setCtbs(String ctbs) {
        this.ctbs = ctbs;
    }
    public static FuncionarioDto fromEntity(Funcionario entity) {
        return new FuncionarioDto(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getRg(),
                entity.getEndereco(),
                entity.getCtbs()
        );
    }
    public Funcionario toEntity() {
        Funcionario entity = new Funcionario();
        entity.setId(this.id);
        entity.setNome(this.nome);
        entity.setCpf(this.cpf);
        entity.setRg(this.rg);
        entity.setEndereco(this.endereco);
        entity.setCtbs(this.ctbs);
        return entity;
    }
}
