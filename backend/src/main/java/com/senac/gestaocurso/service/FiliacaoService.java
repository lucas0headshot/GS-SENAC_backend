package com.senac.gestaocurso.service;

import com.senac.gestaocurso.dto.AulaDto;
import com.senac.gestaocurso.dto.FiliacaoDto;
import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.Filiacao;
import com.senac.gestaocurso.models.domain.Aula;
import com.senac.gestaocurso.repository.FiliacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FiliacaoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FiliacaoRepository filiacaoRepository;

    public Filiacao salvar(Filiacao entity) {
        return filiacaoRepository.save(entity);
    }

    public Page<FiliacaoDto> buscaTodos(String filter, Pageable pageable) {
        Page<Filiacao> filiacaoPage = filiacaoRepository.findAll(filter, Filiacao.class, pageable);

        if (filiacaoPage.isEmpty()){
            throw new NotFoundException("Não há Filiação");
        }
        return filiacaoPage.map(FiliacaoDto::fromEntity);
    }

    public Filiacao buscaPorId(Long id) {
        return filiacaoRepository.findById(id).orElseThrow(() -> new NotFoundException("Filiação não encontrada"));
    }

    public Filiacao alterar(Long id, Filiacao alterado) {
        Optional<Filiacao> encontrado = filiacaoRepository.findById(id);
        if ((encontrado.isPresent())) {
            Filiacao filiacao = encontrado.get();
            modelMapper.map(alterado, filiacao);
            return filiacaoRepository.save(filiacao);
        }
        throw new NotFoundException("Filiaçãonão encontrada");
    }

    public void remover(Long id) {
        filiacaoRepository.deleteById(id);
    }
}