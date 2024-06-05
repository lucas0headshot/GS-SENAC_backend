package com.senac.gestaocurso.strategy.funcionarioValidacaoImp;

import com.senac.gestaocurso.enterprise.ValidationException;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.repository.FuncionarioRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoFuncionarioStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarRg implements NovaValidacaoFuncionarioStrategy {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public void validar(Funcionario funcionario) {
        if (rgValidado(funcionario.getRg())){
            throw new ValidationException("RG já cadastrado");
        }
    }

    private boolean rgValidado(String rg){
        return repository.findByRg(rg) != null;
    }
}
