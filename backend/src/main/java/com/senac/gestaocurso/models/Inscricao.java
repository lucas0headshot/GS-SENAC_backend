package com.senac.gestaocurso.models;



import com.senac.gestaocurso.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDate;



@Entity
public class Inscricao extends EntityID {
    @Column(nullable = false)
    private Funcionario inscrito;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Integer valor;


    public Inscricao() {
    }


    public Funcionario getInscrito() {
        return inscrito;
    }

    public void setInscrito(Funcionario inscrito) {
        this.inscrito = inscrito;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }


    
    @Override
    public String toString() {
        return "Inscricao{" +
                "inscrito=" + inscrito +
                ", data=" + data +
                ", status=" + status +
                ", valor=" + valor +
                '}';
    }
}