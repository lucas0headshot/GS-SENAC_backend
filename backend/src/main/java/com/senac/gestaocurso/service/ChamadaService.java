package com.senac.gestaocurso.service;



import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.Chamada;
import com.senac.gestaocurso.repository.ChamadaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ChamadaService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ChamadaRepository repository;

    public Chamada salvar(Chamada chamada) {
        return repository.save(chamada);
    }

    public Page<Chamada> buscaTodos(Pageable pageable){
        var list = repository.findAll(pageable);

        if (list.isEmpty()){
            throw new NotFoundException("nenhuma chamada encontrada");
        }

        return list;
    }

    public Chamada buscaPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("chamada não encontrada"));
    }

    public Chamada alterar(Long id, Chamada alterado) {
        Optional<Chamada> encontrado = repository.findById(id);

        if (encontrado.isPresent()) {
            Chamada chamada = encontrado.get();
            modelMapper.map(alterado, chamada);
            return repository.save(chamada);
        }

        throw new NotFoundException("chamada não encontrada");
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}