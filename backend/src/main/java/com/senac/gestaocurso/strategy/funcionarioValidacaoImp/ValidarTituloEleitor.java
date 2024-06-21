package com.senac.gestaocurso.strategy.funcionarioValidacaoImp;

import com.senac.gestaocurso.enterprise.exception.ValidationException;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.repository.FuncionarioRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoFuncionarioStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarTituloEleitor implements NovaValidacaoFuncionarioStrategy {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public void validar(Funcionario funcionario) {
        if (tituloValidado(funcionario.getTituloEleitor())){
            throw new ValidationException("Título de Eleitor já cadastrado");
        }
    }

    private boolean tituloValidado(String titulo){
        return repository.findByTituloEleitor(titulo) != null;
    }
}
