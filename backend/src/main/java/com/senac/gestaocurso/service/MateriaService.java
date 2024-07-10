package com.senac.gestaocurso.service;

import com.senac.gestaocurso.dto.MateriaDto;
import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.domain.Materia;
import com.senac.gestaocurso.repository.MateriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MateriaService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MateriaRepository materiaRepository;

    public Materia salvar(Materia entity) {
        Materia materia = Materia.Builder.builder()
                .nome(entity.getNome())
                .cargaHoraria(entity.getCargaHoraria())
                .curso(entity.getCurso())
                .build();
        return materiaRepository.save(materia);
    }

    public Page<MateriaDto> buscaTodos(String filter, Pageable pageable) {
        Page<Materia> materiaPage = materiaRepository.findAll(filter, Materia.class, pageable);

        if (materiaPage.isEmpty()){
            throw new NotFoundException("Nenhuma matéria encontrada");
        }

        return materiaPage.map(MateriaDto::fromEntity);
    }

    public Materia buscaPorId(Long id) {
        return materiaRepository.findById(id).orElseThrow(() -> new NotFoundException("Matéria não encontrada"));
    }

    public Materia alterar(Long id, Materia alterado) {
        Optional<Materia> encontrado = materiaRepository.findById(id);

        if ((encontrado.isPresent())) {
            Materia materia = encontrado.get();
            modelMapper.map(alterado, materia);
            return materiaRepository.save(materia);
        }

        throw new NotFoundException("Matéria não encontrada");
    }

    public void remover(Long id) {
        materiaRepository.deleteById(id);
    }
}
