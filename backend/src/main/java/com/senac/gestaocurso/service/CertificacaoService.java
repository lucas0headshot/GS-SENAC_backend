package com.senac.gestaocurso.service;

import com.senac.gestaocurso.dto.CertificaoDto;
import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.domain.Certificacao;
import com.senac.gestaocurso.repository.CertifcacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CertificacaoService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CertifcacaoRepository certifcacaoRepository;

    public Certificacao salvar(Certificacao entity) {
        return certifcacaoRepository.save(entity);
    }

    public Page<CertificaoDto> buscaTodos(String filter, Pageable pageable) {
        Page<Certificacao> certificacaoPage = certifcacaoRepository.findAll(filter, Certificacao.class, pageable);

        if (certificacaoPage.isEmpty()){
            throw new NotFoundException("Nenhuma certificaçãp encontrado");
        }

        return certificacaoPage.map(CertificaoDto::fromEntity);
    }

    public Certificacao buscaPorId(Long id) {
        return certifcacaoRepository.findById(id).orElseThrow(() -> new NotFoundException("certificação não encontrada"));
    }

    public Certificacao alterar(Long id, Certificacao alterado) {
        Optional<Certificacao> encontrado = certifcacaoRepository.findById(id);

        if (encontrado.isPresent()) {
            Certificacao certificacao = encontrado.get();
            modelMapper.map(alterado, certificacao);
            return certifcacaoRepository.save(certificacao);
        }

        throw new NotFoundException("certificação não encontrada");
    }

    public void remover(Long id) {
        certifcacaoRepository.deleteById(id);
    }
}
