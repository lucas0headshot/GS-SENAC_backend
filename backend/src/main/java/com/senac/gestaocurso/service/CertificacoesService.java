package com.senac.gestaocurso.service;


import com.senac.gestaocurso.models.Aula;
import com.senac.gestaocurso.models.Certificacoes;
import com.senac.gestaocurso.repository.CertifcacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CertificacoesService {
    @Autowired
    private CertifcacoesRepository certifcacoesRepository;
    public Certificacoes salvar(Certificacoes entity) {
        return certifcacoesRepository.save(entity);
    }

    public Page<Certificacoes> buscaTodos(Pageable pageable) {
        return certifcacoesRepository.findAll(pageable);
    }
    public Certificacoes buscaPorId(Long id) {
        return certifcacoesRepository.findById(id).orElse(null);
    }
    public Certificacoes alterar(Long id, Certificacoes alterado) {
        Optional<Certificacoes> encontrado = certifcacoesRepository.findById(id);
        if ((encontrado.isPresent())) {
            Certificacoes certificacoes = encontrado.get();
            certificacoes.setNome(alterado.getNome());
            certificacoes.setCargaHoraria(alterado.getCargaHoraria());
            certificacoes.setDataEmissao(alterado.getDataEmissao());
            return certifcacoesRepository.save(certificacoes);
        }
        return null;
    }
    public void remover(Long id) {certifcacoesRepository.deleteById(id);
    }
}


