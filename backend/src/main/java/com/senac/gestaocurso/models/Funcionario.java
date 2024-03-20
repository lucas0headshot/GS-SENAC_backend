package com.senac.gestaocurso.models;



import com.senac.gestaocurso.enums.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Funcionario extends EntityID {
    @Column(nullable = false)
    private String nome;

<<<<<<< Updated upstream
    @Column
=======
    @Column(nullable = false)
    @CPF(message = "Informe um CPF válido")
>>>>>>> Stashed changes
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String ctbs;

    @Column(nullable = false)
    private Double salarioContratual;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @Enumerated(EnumType.STRING)
    private ModalidadeContratual modalidadeContratual;

    @Column(nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

<<<<<<< Updated upstream
    @Column
=======
    @Column(nullable = false)
    @TituloEleitoral(message = "Informe um título de eleitor válido")
>>>>>>> Stashed changes
    private String tituloEleitor;

    @Column(nullable = false)
    private String reservista;

    @Column(nullable = false)
    private LocalDate dataNasc;

    @Column(nullable = false)
    private String pisPasep;

    @Column(nullable = false)
    private String registroProfissional;

<<<<<<< Updated upstream
    @Column
=======
    @Column(nullable = false)
    @Email(message = "Informe um e-mail válido")
>>>>>>> Stashed changes
    private String email;

    @Column(nullable = false)
    private String sindicato;

    @Column(nullable = false)
    private String setor;

    @Enumerated(EnumType.STRING)
    private TipoRH tipoRH;

    @Column
    private String cnh;

    @Column(nullable = false)
    private LocalDate dataAdmissao;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    @ManyToOne
    @JoinColumn(name = "filiacao_id")
    private Filiacao filiacao;


    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Dependentes>  dependentes;

    @Column(nullable = false)
    private String racaCor;

    @Column(nullable = false)
    private String religiao;

    @Column(nullable = false)
    private Boolean doadorSangue;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificacoes> certificacoeses = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Turno turno;

    @Column(nullable = false)
    private String nacionalidade;

    @Column(nullable = false)
    private String redeSocial;

    @Column(nullable = false)
    private String areaAtuacao;

    @Column(nullable = false)
    private String matricula;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExpAnterior> expAnteriors = new ArrayList<>();

    @Column(nullable = false)
    private String idioma;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DadosBancarios> dadosBancarioses = new ArrayList<>();

    @Column
    private Integer horaExtra;

    @Column(nullable = false)
    private LocalTime horaEntrada;

    @Column(nullable = false)
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

    public List<Dependentes> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependentes> dependentes) {
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