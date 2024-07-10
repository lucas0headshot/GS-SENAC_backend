package com.senac.gestaocurso.service;

import com.senac.gestaocurso.dto.FuncionarioDto;
import com.senac.gestaocurso.enterprise.exception.OkNoContent;
import com.senac.gestaocurso.models.*;
import com.senac.gestaocurso.repository.FuncionarioRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoFuncionarioStrategy;
import com.senac.gestaocurso.strategy.ValidarImplementacaoListasStrategy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private ModelMapper modelMapper;

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

    public Page<FuncionarioDto> buscaTodos(String filter, Pageable pageable) {
        Page<Funcionario> funcionariosPage = funcionarioRepository.findAll(filter, Funcionario.class, pageable);

        if (funcionariosPage.isEmpty()){
            throw new OkNoContent("Nenhum funcionário encontrado");
        }

        return funcionariosPage.map(FuncionarioDto::fromEntity);
    }

    public Funcionario buscaPorId(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new OkNoContent("Funcionário não encontrado"));
    }

    public Funcionario alterar(Long id, Funcionario alterado) {
        Optional<Funcionario> encontrado = funcionarioRepository.findById(id);

        if (encontrado.isPresent()) {
            Funcionario funcionario = encontrado.get();
            modelMapper.map(alterado, funcionario);
            return funcionarioRepository.save(funcionario);
        }

        throw new OkNoContent("Funcionário não encontrado");
    }

    public void remover(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
