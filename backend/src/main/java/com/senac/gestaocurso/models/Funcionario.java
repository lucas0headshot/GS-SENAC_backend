package com.senac.gestaocurso.models;

import com.senac.gestaocurso.enums.*;
import jakarta.persistence.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Funcionario extends EntityID {
    private String nome;

    private String cpf;

    private String rg;

    private String endereco;

    private String ctbs;

    private Double salarioContratual;

    private Integer cargaHoraria;

    private ModalidadeContratual modalidadeContratual;

    private String telefone;

    private EstadoCivil estadoCivil;

    private String tituloEleitor;

    private String reservista;

    private LocalDate dataNasc;

    private String pisPasep;

    private String registroProfissional;

    private String email;

    private String sindicato;

    private String setor;

    private TipoRH tipoRH;

    private String cnh;

    private LocalDate dataAdmissao;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    private Escolaridade escolaridade;

    @ManyToOne
    @JoinColumn(name = "filiacao_id")
    private Filiacao filiacao;

    @ManyToOne
    @JoinColumn(name = "dependentes_id")
    private Dependentes dependentes;

    private String racaCor;

    private String religiao;

    private Boolean doadorSangue;

    private Genero genero;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificacoes> certificacoeses = new ArrayList<>();

    private Turno turno;

    private String nacionalidade;


    private String redeSocial;

    private String areaAtuacao;

    private String matricula;

    private Status status;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExpAnterior> expAnteriors = new ArrayList<>();

    private String idioma;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DadosBancarios> dadosBancarioses = new ArrayList<>();

    private Integer horaExtra;

    private LocalTime horaEntrada;

    private LocalTime horaSaida;



    public Funcionario() {
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCtbs() {
        return ctbs;
    }

    public void setCtbs(String ctbs) {
        this.ctbs = ctbs;
    }

    public Double getSalarioContratual() {
        return salarioContratual;
    }

    public void setSalarioContratual(Double salarioContratual) {
        this.salarioContratual = salarioContratual;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ModalidadeContratual getModalidadeContratual() {
        return modalidadeContratual;
    }

    public void setModalidadeContratual(ModalidadeContratual modalidadeContratual) {
        this.modalidadeContratual = modalidadeContratual;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public String getReservista() {
        return reservista;
    }

    public void setReservista(String reservista) {
        this.reservista = reservista;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getPisPasep() {
        return pisPasep;
    }

    public void setPisPasep(String pisPasep) {
        this.pisPasep = pisPasep;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSindicato() {
        return sindicato;
    }

    public void setSindicato(String sindicato) {
        this.sindicato = sindicato;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public TipoRH getTipoRH() {
        return tipoRH;
    }

    public void setTipoRH(TipoRH tipoRH) {
        this.tipoRH = tipoRH;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Filiacao getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(Filiacao filiacao) {
        this.filiacao = filiacao;
    }

    public Dependentes getDependentes() {
        return dependentes;
    }

    public void setDependentes(Dependentes dependentes) {
        this.dependentes = dependentes;
    }

    public String getRacaCor() {
        return racaCor;
    }

    public void setRacaCor(String racaCor) {
        this.racaCor = racaCor;
    }

    public String getReligiao() {
        return religiao;
    }

    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    public Boolean getDoadorSangue() {
        return doadorSangue;
    }

    public void setDoadorSangue(Boolean doadorSangue) {
        this.doadorSangue = doadorSangue;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<DadosBancarios> getDadosBancarioses() {
        return dadosBancarioses;
    }

    public void setDadosBancarioses(List<DadosBancarios> dadosBancarioses) {
        this.dadosBancarioses = dadosBancarioses;
    }

    public List<ExpAnterior> getExpAnteriors() {
        return expAnteriors;
    }

    public void setExpAnteriors(List<ExpAnterior> expAnteriors) {
        this.expAnteriors = expAnteriors;
    }

    public List<Certificacoes> getCertificacoeses() {
        return certificacoeses;
    }

    public void setCertificacoeses(List<Certificacoes> certificacoeses) {
        this.certificacoeses = certificacoeses;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }


    public Integer getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(Integer horaExtra) {
        this.horaExtra = horaExtra;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", endereco='" + endereco + '\'' +
                ", ctbs='" + ctbs + '\'' +
                ", salarioContratual=" + salarioContratual +
                ", cargaHoraria=" + cargaHoraria +
                ", modalidadeContratual=" + modalidadeContratual +
                ", telefone='" + telefone + '\'' +
                ", estadoCivil=" + estadoCivil +
                ", tituloEleitor='" + tituloEleitor + '\'' +
                ", reservista='" + reservista + '\'' +
                ", dataNasc=" + dataNasc +
                ", pisPasep='" + pisPasep + '\'' +
                ", registroProfissional='" + registroProfissional + '\'' +
                ", email='" + email + '\'' +
                ", sindicato='" + sindicato + '\'' +
                ", setor='" + setor + '\'' +
                ", tipoRH=" + tipoRH +
                ", cnh='" + cnh + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                ", cargo=" + cargo +
                ", escolaridade=" + escolaridade +
                ", filiacao=" + filiacao +
                ", dependentes=" + dependentes +
                ", racaCor='" + racaCor + '\'' +
                ", religiao='" + religiao + '\'' +
                ", doadorSangue=" + doadorSangue +
                ", genero=" + genero +
                ", certificacoes=" + certificacoeses +
                ", turno=" + turno +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", redeSocial='" + redeSocial + '\'' +
                ", areaAtuacao='" + areaAtuacao + '\'' +
                ", matricula='" + matricula + '\'' +
                ", status=" + status +
                ", expAnterior=" + expAnteriors +
                ", idioma='" + idioma + '\'' +
                ", dadosBancarios=" + dadosBancarioses +
                ", horaExtra=" + horaExtra +
                ", horaEntrada=" + horaEntrada +
                ", horaSaida=" + horaSaida +
                '}';
    }
}