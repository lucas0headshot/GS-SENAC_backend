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

    public static class Builder {
        private String nomePai;
        private String telefonePai;
        private String nomeMae;
        private String telefoneMae;

        public Builder nomePai(String nomePai) {
            this.nomePai = nomePai;
            return this;
        }

        public Builder telefonePai(String telefonePai) {
            this.telefonePai = telefonePai;
            return this;
        }

        public Builder nomeMae(String nomeMae) {
            this.nomeMae = nomeMae;
            return this;
        }

        public Builder telefoneMae(String telefoneMae) {
            this.telefoneMae = telefoneMae;
            return this;
        }

        public Filiacao build() {
            return new Filiacao(this);
        }
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