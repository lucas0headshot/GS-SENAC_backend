package com.senac.gestaocurso.service;


import com.senac.gestaocurso.models.DadosBancario;
import com.senac.gestaocurso.repository.DadosBancariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DadosBancariosService {
    @Autowired
    private DadosBancariosRepository dadosBancariosRepository;
    public DadosBancario salvar(DadosBancario entity) {
        return dadosBancariosRepository.save(entity);
    }
    public Page<DadosBancario> buscaTodos(Pageable pageable) {
        return dadosBancariosRepository.findAll(pageable);
    }
    public DadosBancario buscaPorId(Long id) {
        return dadosBancariosRepository.findById(id).orElse(null);
    }
    public DadosBancario alterar(Long id, DadosBancario alterado) {
        Optional<DadosBancario> encontrado = dadosBancariosRepository.findById(id);
        if ((encontrado.isPresent())) {
            DadosBancario dadosBancario = encontrado.get();
            dadosBancario.setBanco(alterado.getBanco());
            dadosBancario.setAgencia(alterado.getAgencia());
            dadosBancario.setConta(alterado.getConta());
            dadosBancario.setTipoContaBancaria(alterado.getTipoContaBancaria());
            return dadosBancariosRepository.save(dadosBancario);
        }
        return null;
    }
    public void remover(Long id) {
        dadosBancariosRepository.deleteById(id);
    }
}

