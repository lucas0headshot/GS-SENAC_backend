package com.senac.gestaocurso.service;

import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.domain.Frequencia;
import com.senac.gestaocurso.repository.FrequenciaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class FrequenciaService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FrequenciaRepository frequenciaRepository;

    public Frequencia salvar(Frequencia entity) {
        return frequenciaRepository.save(entity);
    }

    public Page<Frequencia> buscaTodos(Pageable pageable) {
        var list = frequenciaRepository.findAll(pageable);

        if (list.isEmpty()){
            throw new NotFoundException("Nenhuma frequência encontrada");
        }

        return list;
    }

    public Frequencia buscaPorId(Long id) {
        return frequenciaRepository.findById(id).orElseThrow(() -> new NotFoundException("Frequência não encontrada"));
    }

    public Frequencia alterar(Long id, Frequencia alterado) {
        Optional<Frequencia> encontrado = frequenciaRepository.findById(id);
        if ((encontrado.isPresent())) {
            Frequencia frequencia = encontrado.get();
            modelMapper.map(alterado, frequencia);
            return frequenciaRepository.save(frequencia);
        }
        throw new NotFoundException("Frequência não encontrada");
    }

    public void remover(Long id) {frequenciaRepository.deleteById(id);
    }
}
