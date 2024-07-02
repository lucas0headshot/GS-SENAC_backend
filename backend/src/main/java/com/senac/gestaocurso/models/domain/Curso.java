package com.senac.gestaocurso.models.domain;



import com.senac.gestaocurso.models.EntityID;
import com.senac.gestaocurso.models.Funcionario;
import jakarta.persistence.*;



@Entity
public class Curso extends EntityID {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordenador_id")
    private Funcionario coordenador;

    @Column(nullable = false)
    private Integer cargaHorariaTotal;




    public Curso() {
    }

    public Curso(Builder builder) {
        this.nome = builder.nome;
        this.descricao = builder.descricao;
        this.coordenador = builder.coordenador;
        this.cargaHorariaTotal = builder.cargaHorariaTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcionario getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Funcionario coordenador) {
        this.coordenador = coordenador;
    }

    public Integer getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(Integer cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }



    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", coordenador=" + coordenador +
                ", cargaHorariaTotal=" + cargaHorariaTotal +
                '}';
    }

    public static class Builder {
        private String nome;
        private String descricao;
        private Funcionario coordenador;
        private Integer cargaHorariaTotal;

        public Builder(){
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder descricao(String descricao){
            this.descricao = descricao;
            return this;
        }

        public Builder coordenador(Funcionario coordenador){
            this.coordenador = coordenador;
            return this;
        }

        public Builder cargaHorariaTotal(Integer cargaHorariaTotal){
            this.cargaHorariaTotal = cargaHorariaTotal;
            return this;
        }

        public Curso build(){
            return new Curso(this);
        }
    }
}