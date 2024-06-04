package com.senac.gestaocurso.service;


import com.senac.gestaocurso.models.domain.Certificacao;
import com.senac.gestaocurso.repository.CertifcacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CertificacoesService {
    @Autowired
    private CertifcacoesRepository certifcacoesRepository;
    public Certificacao salvar(Certificacao entity) {
        return certifcacoesRepository.save(entity);
    }

    public Page<Certificacao> buscaTodos(Pageable pageable) {
        return certifcacoesRepository.findAll(pageable);
    }
    public Certificacao buscaPorId(Long id) {
        return certifcacoesRepository.findById(id).orElse(null);
    }
    public Certificacao alterar(Long id, Certificacao alterado) {
        Optional<Certificacao> encontrado = certifcacoesRepository.findById(id);
        if ((encontrado.isPresent())) {
            Certificacao certificacao = encontrado.get();
            certificacao.setNome(alterado.getNome());
            certificacao.setCargaHoraria(alterado.getCargaHoraria());
            certificacao.setDataEmissao(alterado.getDataEmissao());
            return certifcacoesRepository.save(certificacao);
        }
        return null;
    }
    public void remover(Long id) {certifcacoesRepository.deleteById(id);
    }
}


