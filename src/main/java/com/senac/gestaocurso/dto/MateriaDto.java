package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.domain.Materia;

public class MateriaDto {
    private Long id;
    private  String nome;
    private  Integer cargaHoraria;

    public MateriaDto(){}

    public MateriaDto(Long id, String nome, Integer cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
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

    public static MateriaDto fromEntity(Materia entity){
        return new MateriaDto(
            entity.getId(),
            entity.getNome(),
            entity.getCargaHoraria()
        );
    }

    public Materia toEntity(){
        return Materia.Builder.builder()
                .nome(this.nome)
                .cargaHoraria(this.cargaHoraria)
                .build();
    }
}
