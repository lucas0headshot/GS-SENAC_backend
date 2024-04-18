package com.senac.gestaocurso.service;

import com.senac.gestaocurso.models.*;
import com.senac.gestaocurso.repository.DependentesRepository;
import com.senac.gestaocurso.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private DependentesRepository dependentesRepository;

    public Funcionario salvar(Funcionario entity) {

        List<Dependentes> dependentesList = entity.getDependentes()
                .stream()
                .map(dependentesIn -> new Dependentes(
                        dependentesIn.getNome(),
                        dependentesIn.getEscolaridade(),
                        dependentesIn.getDataNasc(),
                        entity))
                .collect(Collectors.toList());

        entity.setDependentes(dependentesList);



        List<ExpAnterior> expAnteriorList = entity.getExpAnterior()
                .stream()
                .map(expAnteriorIn -> new ExpAnterior(
                        expAnteriorIn.getDescricao(),
                        expAnteriorIn.getCargo(),
                        expAnteriorIn.getPeriodoFinal(),
                        expAnteriorIn.getPeriodoInicial(),
                        entity))
                .collect(Collectors.toList());

        entity.setExpAnterior(expAnteriorList);



        List<Certificacoes> certificacoesList = entity.getCertificacoes()
                .stream()
                .map(certificacoesIn -> new Certificacoes(
                        certificacoesIn.getNome(),
                        certificacoesIn.getCargaHoraria(),
                        certificacoesIn.getDataEmissao(),
                        entity))
                .collect(Collectors.toList());

        entity.setCertificacoes(certificacoesList);



        List<DadosBancarios> dadosBancariosList = entity.getDadosBancarios()
                .stream()
                .map(dadosBancariosIn -> new DadosBancarios(
                        dadosBancariosIn.getBanco(),
                        dadosBancariosIn.getAgencia(),
                        dadosBancariosIn.getAgencia(),
                        dadosBancariosIn.getTipoContaBancaria(),
                        entity))
                .collect(Collectors.toList());

        entity.setDadosBancarios(dadosBancariosList);

        return funcionarioRepository.save(entity);

    }

    public Page<Funcionario> buscaTodos(Pageable pageable) {
        return funcionarioRepository.findAll(pageable);
    }
    public Funcionario buscaPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }
    public Funcionario alterar(Long id, Funcionario alterado) {
        Optional<Funcionario> encontrado = funcionarioRepository.findById(id);
        if ((encontrado.isPresent())) {

            Funcionario funcionario = encontrado.get();
            funcionario.setEmail(alterado.getEmail());
            funcionario.setNome(alterado.getNome());
            funcionario.setEndereco(alterado.getEndereco());
            funcionario.setCargo(alterado.getCargo());
            funcionario.setCnh(alterado.getCnh());
            funcionario.setAreaAtuacao(alterado.getAreaAtuacao());
            funcionario.setCpf(alterado.getCpf());
            funcionario.setCargaHoraria(alterado.getCargaHoraria());
            funcionario.setDadosBancarios(alterado.getDadosBancarios());
            funcionario.setCtbs(alterado.getCtbs());
            funcionario.setCertificacoes(alterado.getCertificacoes());
            funcionario.setExpAnterior(alterado.getExpAnterior());
            funcionario.setDependentes(alterado.getDependentes());
            funcionario.setTituloEleitor(alterado.getTituloEleitor());
            funcionario.setTipoRH(alterado.getTipoRH());
            funcionario.setTelefone(alterado.getTelefone());
            funcionario.setReservista(alterado.getReservista());
            funcionario.setStatus(alterado.getStatus());
            funcionario.setRg(alterado.getRg());
            funcionario.setSalarioContratual(alterado.getSalarioContratual());
            funcionario.setModalidadeContratual(alterado.getModalidadeContratual());
            funcionario.setDataNasc(alterado.getDataNasc());
            funcionario.setPisPasep(alterado.getPisPasep());
            funcionario.setRegistroProfissional(alterado.getRegistroProfissional());
            funcionario.setSindicato(alterado.getSindicato());
            funcionario.setSetor(alterado.getSetor());
            funcionario.setDataAdmissao(alterado.getDataAdmissao());
            funcionario.setFiliacao(alterado.getFiliacao());
            funcionario.setRacaCor(alterado.getRacaCor());
            funcionario.setReligiao(alterado.getReligiao());
            funcionario.setDoadorSangue(alterado.getDoadorSangue());
            funcionario.setGenero(alterado.getGenero());
            funcionario.setTurno(alterado.getTurno());
            funcionario.setNacionalidade(alterado.getNacionalidade());
            funcionario.setRedeSocial(alterado.getRedeSocial());
            funcionario.setMatricula(alterado.getMatricula());
            funcionario.setIdioma(alterado.getIdioma());
            funcionario.setHoraExtra(alterado.getHoraExtra());
            funcionario.setHoraEntrada(alterado.getHoraEntrada());
            funcionario.setHoraSaida(alterado.getHoraSaida());

            return funcionarioRepository.save(funcionario);
        }
        return null;
    }
    public void remover(Long id) {funcionarioRepository.deleteById(id);
    }

}
