package com.senac.gestaocurso.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;



@Entity
public class Filiacao extends EntityID {
    @Column(nullable = false)
    private String nomePai;

    @Column(nullable = false)
    private String telefonePai;

    @Column(nullable = false)
    private String nomeMae;

    @Column(nullable = false)
    private String telefoneMae;



    public Filiacao() {
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getTelefonePai() {
        return telefonePai;
    }

    public void setTelefonePai(String telefonePai) {
        this.telefonePai = telefonePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getTelefoneMae() {
        return telefoneMae;
    }

    public void setTelefoneMae(String telefoneMae) {
        this.telefoneMae = telefoneMae;
    }



    @Override
    public String toString() {
        return "Filiacao{" +
                "nomePai='" + nomePai + '\'' +
                ", telefonePai='" + telefonePai + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", telefoneMae='" + telefoneMae + '\'' +
                '}';
    }
}