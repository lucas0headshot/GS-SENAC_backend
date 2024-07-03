package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.domain.Aula;
import java.time.LocalDate;

public class AulaDto {
    private  Long id;
    private  LocalDate dia;

    public AulaDto() {}

    public AulaDto(Long id, LocalDate dia) {
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

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public static AulaDto fromEntity(Aula entity){
        return new AulaDto(
            entity.getId(),
            entity.getDia()
        );
    }

    public Aula toEntity(){
        Aula entity = new Aula();
        entity.setDia(this.dia);
        entity.setId(this.id);
        return entity;
    }
}
