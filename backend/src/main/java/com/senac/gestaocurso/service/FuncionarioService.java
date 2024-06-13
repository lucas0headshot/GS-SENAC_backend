package com.senac.gestaocurso.service;

import com.senac.gestaocurso.dto.FuncionarioDto;
import com.senac.gestaocurso.models.*;
import com.senac.gestaocurso.repository.FuncionarioRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoFuncionarioStrategy;
import com.senac.gestaocurso.strategy.ValidarImplementacaoListasStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private List<NovaValidacaoFuncionarioStrategy> novaValidacaoFuncionarioStrategies;
    @Autowired
    private List<ValidarImplementacaoListasStrategy> validarImplementacaoListasStrategies;

    public Funcionario salvar(Funcionario entity) {
        novaValidacaoFuncionarioStrategies.forEach(validacao -> validacao.validar(entity));
        validarImplementacaoListasStrategies.forEach(validacao -> validacao.lista(entity));
        return funcionarioRepository.save(entity);
    }

    public Page<FuncionarioDto> buscaTodos(Pageable pageable) {
        Page<Funcionario> funcionariosPage = funcionarioRepository.findAll(pageable);
        return funcionariosPage.map(FuncionarioDto::fromEntity);
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
