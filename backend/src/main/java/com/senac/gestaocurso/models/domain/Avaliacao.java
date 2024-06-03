package com.senac.gestaocurso.models.domain;



import com.senac.gestaocurso.models.EntityID;
import jakarta.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;



@Entity
public class Avaliacao extends EntityID {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "materia_id")
    private Materia materia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Inscricao aluno;

    @Column(nullable = false)
    private String nome;

    @Column
    @Min(value = 0, message = "A nota deve ser no mínimo 0")
    @Max(value = 10, message = "A nota deve ser no máximo 10")
    private Integer nota;

    @Column(nullable = false)
    private LocalDate data;



    public Avaliacao() {
    }





    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Inscricao getAluno() {
        return aluno;
    }

    public void setAluno(Inscricao aluno) {
        this.aluno = aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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



    @Override
    public String toString() {
        return "Avaliacao{" +
                "aluno=" + aluno +
                ", materia=" + materia +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", data=" + data +
                '}';
    }
}