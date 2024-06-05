package com.senac.gestaocurso.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class FeedbackDto implements Serializable {
    private final String feedback;
    private final Integer nota;
    private final LocalDate data;

    public FeedbackDto(String feedback, Integer nota, LocalDate data) {
        this.feedback = feedback;
        this.nota = nota;
        this.data = data;
    }

    public String getFeedback() {
        return feedback;
    }

    public Integer getNota() {
        return nota;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackDto entity = (FeedbackDto) o;
        return Objects.equals(this.feedback, entity.feedback) &&
                Objects.equals(this.nota, entity.nota) &&
                Objects.equals(this.data, entity.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedback, nota, data);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "feedback = " + feedback + ", " +
                "nota = " + nota + ", " +
                "data = " + data + ")";
    }
}