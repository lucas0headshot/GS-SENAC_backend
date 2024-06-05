package com.senac.gestaocurso.dto;

import java.io.Serializable;
import java.util.Objects;


public class FiliacaoDto implements Serializable {
    private final String nomePai;
    private final String telefonePai;
    private final String nomeMae;
    private final String telefoneMae;

    public FiliacaoDto(String nomePai, String telefonePai, String nomeMae, String telefoneMae) {
        this.nomePai = nomePai;
        this.telefonePai = telefonePai;
        this.nomeMae = nomeMae;
        this.telefoneMae = telefoneMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public String getTelefonePai() {
        return telefonePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public String getTelefoneMae() {
        return telefoneMae;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiliacaoDto entity = (FiliacaoDto) o;
        return Objects.equals(this.nomePai, entity.nomePai) &&
                Objects.equals(this.telefonePai, entity.telefonePai) &&
                Objects.equals(this.nomeMae, entity.nomeMae) &&
                Objects.equals(this.telefoneMae, entity.telefoneMae);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomePai, telefonePai, nomeMae, telefoneMae);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nomePai = " + nomePai + ", " +
                "telefonePai = " + telefonePai + ", " +
                "nomeMae = " + nomeMae + ", " +
                "telefoneMae = " + telefoneMae + ")";
    }
}