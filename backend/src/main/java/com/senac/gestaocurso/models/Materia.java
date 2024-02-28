package com.senac.gestaocurso.models;



<<<<<<< HEAD:backend/src/main/java/com/senac/gestaocurso/models/Materia.java
import jakarta.persistence.Entity;



@Entity
public class Materia extends EntityID {
    private String nome;
    private Integer cargaHoraria;
    private Funcionario nomeProfessor;


=======
    private String nome;
    private Integer cargaHoraria;
    private Funcionario nomeProfessor;
>>>>>>> f070a55371494f65c99fea6c39e825d246bee57c:gestao-curso/src/main/java/com/senac/gestaocurso/models/Materia.java

    public Materia() {
    }

<<<<<<< HEAD:backend/src/main/java/com/senac/gestaocurso/models/Materia.java


    public String getNomeDaMateria() {
        return nome;
    }

    public void setNomeDaMateria(String nomeDaMateria) {
        this.nome = nomeDaMateria;
=======
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
>>>>>>> f070a55371494f65c99fea6c39e825d246bee57c:gestao-curso/src/main/java/com/senac/gestaocurso/models/Materia.java
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Funcionario getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(Funcionario nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

<<<<<<< HEAD:backend/src/main/java/com/senac/gestaocurso/models/Materia.java

=======
>>>>>>> f070a55371494f65c99fea6c39e825d246bee57c:gestao-curso/src/main/java/com/senac/gestaocurso/models/Materia.java

    @Override
    public String toString() {
        return "Materia{" +
                "nomeDaMateria='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", nomeProfessor=" + nomeProfessor +
                '}';
    }
}
