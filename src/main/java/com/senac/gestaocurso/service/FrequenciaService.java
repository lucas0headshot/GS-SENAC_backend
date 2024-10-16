package com.senac.gestaocurso.service;

import com.senac.gestaocurso.dto.FrequenciaDto;
import com.senac.gestaocurso.enterprise.exception.OkNoContent;
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

    public Page<FrequenciaDto> buscaTodos(String filter, Pageable pageable) {
        Page<Frequencia> frequenciasPage = frequenciaRepository.findAll(filter, Frequencia.class, pageable);

        if (frequenciasPage.isEmpty()){
            throw new OkNoContent("Nenhuma frequência enscontrada");
        }

        return frequenciasPage.map(FrequenciaDto::fromEntity);
    }

    public Frequencia buscaPorId(Long id) {
        return frequenciaRepository.findById(id).orElseThrow(() -> new OkNoContent("Frequência não encontrada"));
    }

    public Frequencia alterar(Long id, Frequencia alterado) {
        Optional<Frequencia> encontrado = frequenciaRepository.findById(id);
        if ((encontrado.isPresent())) {
            Frequencia frequencia = encontrado.get();
            modelMapper.map(alterado, frequencia);
            return frequenciaRepository.save(frequencia);
        }
        throw new OkNoContent("Frequência não encontrada");
    }

    public void remover(Long id) {frequenciaRepository.deleteById(id);
    }
}
