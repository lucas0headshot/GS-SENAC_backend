package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.models.Filiacao;

public class FiliacaoDto {
    private  String nomePai;
    private  String telefonePai;
    private  String nomeMae;
    private  String telefoneMae;

    public FiliacaoDto(){}

    public FiliacaoDto(String nomePai, String telefonePai, String nomeMae, String telefoneMae) {
        this.nomePai = nomePai;
        this.telefonePai = telefonePai;
        this.nomeMae = nomeMae;
        this.telefoneMae = telefoneMae;
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

    public static FiliacaoDto fromEntity(Filiacao entity){
        return new FiliacaoDto(
            entity.getNomePai(),
            entity.getTelefonePai(),
            entity.getNomeMae(),
            entity.getTelefoneMae()
        );
    }

    public Filiacao toEntity(){
        Filiacao entity = new Filiacao();
        entity.setNomePai(this.nomePai);
        entity.setTelefonePai(this.telefonePai);
        entity.setNomeMae(this.nomeMae);
        entity.setTelefoneMae(this.telefoneMae);
        return entity;
    }
}
