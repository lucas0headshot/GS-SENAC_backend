package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.domain.Frequencia;

public class FrequenciaDto {
    private Boolean frequencia;
    private AulaDto aula;
    private InscricaoDto aluno;

    public FrequenciaDto() {
    }

    public FrequenciaDto(Boolean frequencia, AulaDto aula, InscricaoDto aluno) {
        this.frequencia = frequencia;
        this.aula = aula;
        this.aluno = aluno;
    }

    public Boolean getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Boolean frequencia) {
        this.frequencia = frequencia;
    }

    public AulaDto getAula() {
        return aula;
    }

    public void setAula(AulaDto aula) {
        this.aula = aula;
    }

    public InscricaoDto getAluno() {
        return aluno;
    }

    public void setAluno(InscricaoDto aluno) {
        this.aluno = aluno;
    }

    public static FrequenciaDto fromEntity(Frequencia entity) {
        return new FrequenciaDto(
            entity.getFrequencia(),
            AulaDto.fromEntity(entity.getAula()),
            InscricaoDto.fromEntity(entity.getInscricao())
        );
    }

    public Frequencia toEntity() {
        return new Frequencia.Builder()
            .frequencia(frequencia)
            .aula(aula.toEntity())
            .aluno(aluno.toEntity())
            .build();
    }
}
