package com.senac.gestaocurso.service;


import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.DadosBancario;
import com.senac.gestaocurso.repository.DadosBancariosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DadosBancariosService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DadosBancariosRepository dadosBancariosRepository;

    public DadosBancario salvar(DadosBancario entity) {
        return dadosBancariosRepository.save(entity);
    }

    public Page<DadosBancario> buscaTodos(Pageable pageable) {
        var list = dadosBancariosRepository.findAll(pageable);

        if (list.isEmpty()){
            throw new NotFoundException("Nenhum dado bancário encontrado");
        }

        return list;
    }

    public DadosBancario buscaPorId(Long id) {
        return dadosBancariosRepository.findById(id).orElseThrow(() -> new NotFoundException("Dado bancário não encontrado"));
    }

    public DadosBancario alterar(Long id, DadosBancario alterado) {
        Optional<DadosBancario> encontrado = dadosBancariosRepository.findById(id);
        if ((encontrado.isPresent())) {
            DadosBancario dadosBancario = encontrado.get();
            modelMapper.map(alterado, dadosBancario);
            return dadosBancariosRepository.save(dadosBancario);
        }
        throw new NotFoundException("Dado bancário não encontrado");
    }

    public void remover(Long id) {
        dadosBancariosRepository.deleteById(id);
    }
}

