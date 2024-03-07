package com.senac.gestaocurso.service;


import com.senac.gestaocurso.models.Avaliacao;
import com.senac.gestaocurso.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    public Avaliacao salvar(Avaliacao entity) {return avaliacaoRepository.save(entity);}
    public List<Avaliacao> buscaTodos() {
        return avaliacaoRepository.findAll();
    }
    public Avaliacao buscaPorId(Long id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }
    public Avaliacao alterar(Long id, Avaliacao alterado) {
        Optional<Avaliacao> encontrado = avaliacaoRepository.findById(id);
        if ((encontrado.isPresent())) {

            /**
             * Classe precisa ser re-analisada
             * */

        }
        return null;
    }
    public void remover(Long id) {avaliacaoRepository.deleteById(id);
    }


}
