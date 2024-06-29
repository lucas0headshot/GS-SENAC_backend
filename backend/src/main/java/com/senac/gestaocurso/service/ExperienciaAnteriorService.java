package com.senac.gestaocurso.service;

import com.senac.gestaocurso.dto.ExperiencaAnteriorDto;
import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.ExperienciaAnterior;
import com.senac.gestaocurso.repository.ExperienciaAnteriorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ExperienciaAnteriorService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ExperienciaAnteriorRepository experienciaAnteriorRepository;

    public ExperienciaAnterior salvar(ExperienciaAnterior entity) {
        return experienciaAnteriorRepository.save(entity);
    }

    public Page<ExperiencaAnteriorDto> buscaTodos(String filter, Pageable pageable) {
        Page<ExperienciaAnterior> experienciaAnteriorPage = experienciaAnteriorRepository.findAll(filter, ExperienciaAnterior.class, pageable);

        if (experienciaAnteriorPage.isEmpty()){
            throw new NotFoundException("Nenhuma experiencia encontrada");
        }
        return experienciaAnteriorPage.map(ExperiencaAnteriorDto::fromEntity);
    }

    public ExperienciaAnterior buscaPorId(Long id) {
        return experienciaAnteriorRepository.findById(id).orElseThrow(() -> new NotFoundException("Experiência anterior não encontrada"));
    }

    public ExperienciaAnterior alterar(Long id, ExperienciaAnterior alterado) {
        Optional<ExperienciaAnterior> encontrado = experienciaAnteriorRepository.findById(id);

        if ((encontrado.isPresent())) {
            ExperienciaAnterior experienciaAnterior = encontrado.get();
            modelMapper.map(alterado, experienciaAnterior);
            return experienciaAnteriorRepository.save(experienciaAnterior);
        }

        throw new NotFoundException("Experiência anterior não encontrada");
    }

    public void remover(Long id) {
        experienciaAnteriorRepository.deleteById(id);
    }
}
