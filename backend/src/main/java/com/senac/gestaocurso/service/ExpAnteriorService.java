package com.senac.gestaocurso.service;


import com.senac.gestaocurso.models.ExpAnterior;
import com.senac.gestaocurso.repository.ExpAnteriorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ExpAnteriorService {

    @Autowired
    private ExpAnteriorRepository expAnteriorRepository;
    public ExpAnterior salvar(ExpAnterior entity) {return expAnteriorRepository.save(entity);}
    public List<ExpAnterior> buscaTodos() {
        return expAnteriorRepository.findAll();
    }
    public ExpAnterior buscaPorId(Long id) {
        return expAnteriorRepository.findById(id).orElse(null);
    }
    public ExpAnterior alterar(Long id, ExpAnterior alterado) {
        Optional<ExpAnterior> encontrado = expAnteriorRepository.findById(id);
        if ((encontrado.isPresent())) {
            ExpAnterior expAnterior = encontrado.get();
            expAnterior.setCargo(alterado.getCargo());
            expAnterior.setDescricao(alterado.getDescricao());
            expAnterior.setPeridoInicial(alterado.getPeridoInicial());
            expAnterior.setPeriodoFinal(alterado.getPeriodoFinal());
            return expAnteriorRepository.save(expAnterior);
        }
        return null;
    }
    public void remover(Long id) {expAnteriorRepository.deleteById(id);
    }

}

