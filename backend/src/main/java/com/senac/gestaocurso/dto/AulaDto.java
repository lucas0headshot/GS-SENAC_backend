package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.domain.Aula;
import com.senac.gestaocurso.models.domain.Materia;

import java.time.LocalDate;

public class AulaDto {

    private  String nomeProfessor;
    private  String nome;
    private  Long id;
    private  LocalDate dia;

    public AulaDto() {}

    public AulaDto(String nomeProfessor ,String nome, Long id, LocalDate dia) {
        this.nomeProfessor = nomeProfessor;
        this.nome = nome;
        this.id = id;
        this.dia = dia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDia() {
        return dia;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }


        public static AulaDto fromEntity(Aula entity){
            return new AulaDto(

                    entity.getProfessor().getNome(),
                    entity.getMateria().getNome(),
                    entity.getId(),
                    entity.getDia()
            );
        }

    public Aula toEntity(){
        return Aula.Builder.builder()
                .dia(this.dia)
                .build();
    }
}
