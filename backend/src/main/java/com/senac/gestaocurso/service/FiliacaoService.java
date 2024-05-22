package com.senac.gestaocurso.service;

import com.senac.gestaocurso.models.Filiacao;
import com.senac.gestaocurso.repository.FiliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FiliacaoService {

    @Autowired
    private FiliacaoRepository filiacaoRepository;
    public Filiacao salvar(Filiacao entity) {
        return filiacaoRepository.save(entity);
    }
    public Page<Filiacao> buscaTodos(Pageable pageable) {
        return filiacaoRepository.findAll(pageable);
    }
    public Filiacao buscaPorId(Long id) {
        return filiacaoRepository.findById(id).orElse(null);
    }
    public Filiacao alterar(Long id, Filiacao alterado) {
        Optional<Filiacao> encontrado = filiacaoRepository.findById(id);
        if ((encontrado.isPresent())) {
            Filiacao filiacao = encontrado.get();
            filiacao.setNomeMae(alterado.getNomeMae());
            filiacao.setNomePai(alterado.getNomePai());
            filiacao.setTelefoneMae(alterado.getTelefoneMae());
            filiacao.setTelefonePai(alterado.getTelefonePai());
            return filiacaoRepository.save(filiacao);
        }
        return null;
    }
    public void remover(Long id) {filiacaoRepository.deleteById(id);
    }
}