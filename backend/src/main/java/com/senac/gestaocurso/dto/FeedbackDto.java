package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.domain.Feedback;
import java.time.LocalDate;

public class FeedbackDto {
    private  String feedback;
    private  Integer nota;
    private  LocalDate data;

    public FeedbackDto(){}

    public FeedbackDto(String feedback, Integer nota, LocalDate data) {
        this.feedback = feedback;
        this.nota = nota;
        this.data = data;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public static FeedbackDto fromEntity(FeedbackDto entity){
        return new FeedbackDto(
            entity.getFeedback(),
            entity.getNota(),
            entity.getData()
        );
    }

    public  Feedback toEntity(){
        Feedback entity = new Feedback();
        entity.setFeedback(this.feedback);
        entity.setNota(this.nota);
        entity.setData(this.data);
        return entity;
    }
}
