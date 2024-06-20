package com.senac.gestaocurso.service;


import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.domain.Avaliacao;
import com.senac.gestaocurso.repository.AvaliacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    public Avaliacao salvar(Avaliacao entity) {
        return avaliacaoRepository.save(entity);
    }
    public Page<Avaliacao> buscaTodos(Pageable pageable) {
        var list = avaliacaoRepository.findAll(pageable);

        if (list.isEmpty()){
            throw new NotFoundException("nenhuma avaliação encontrada");
        }

        return list;
    }
    public Avaliacao buscaPorId(Long id) {
        return avaliacaoRepository.findById(id).orElseThrow(() -> new NotFoundException("avaliação não encontrada"));
    }
    public Avaliacao alterar(Long id, Avaliacao alterado) {
        Optional<Avaliacao> encontrado = avaliacaoRepository.findById(id);
        if (encontrado.isPresent()) {
            Avaliacao avaliacao = encontrado.get();
            modelMapper.map(alterado, avaliacao);
            return avaliacaoRepository.save(avaliacao);
        }
        throw new NotFoundException("avaliação não encontrada");
    }
    public void remover(Long id) {
        avaliacaoRepository.deleteById(id);
    }


}
