package com.senac.gestaocurso.strategy.funcionarioValidacaoImp;

import com.senac.gestaocurso.enterprise.exception.ValidationException;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.repository.FuncionarioRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoFuncionarioStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarCtbs implements NovaValidacaoFuncionarioStrategy {
    @Autowired
    private FuncionarioRepository repository;

    @Override
    public void validar(Funcionario funcionario) {
        if (ctbsValidado(funcionario.getCtbs())){
            throw new ValidationException("CTBS já cadastrado");
        }
    }

    private Boolean ctbsValidado(String ctbs){
        return repository.findByCtbs(ctbs) != null;
    }
}
