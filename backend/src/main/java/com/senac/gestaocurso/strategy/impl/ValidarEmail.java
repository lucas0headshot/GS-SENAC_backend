package com.senac.gestaocurso.strategy.impl;

import com.senac.gestaocurso.enterprise.ValidationException;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.repository.FuncionarioRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoFuncionarioStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarEmail implements NovaValidacaoFuncionarioStrategy {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public void validar(Funcionario funcionario) {
        if (emailValidado(funcionario.getEmail())){
            throw new ValidationException("Email já está em uso");
        }
    }

    private boolean emailValidado(String email){
        return repository.findByEmail(email) != null;
    }
}
