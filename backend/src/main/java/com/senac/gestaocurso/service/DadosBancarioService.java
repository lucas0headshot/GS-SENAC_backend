package com.senac.gestaocurso.service;

import com.senac.gestaocurso.dto.DadosBancarioDto;
import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.DadosBancario;
import com.senac.gestaocurso.repository.DadosBancarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DadosBancarioService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DadosBancarioRepository dadosBancarioRepository;

    public DadosBancario salvar(DadosBancario entity) {
        return dadosBancarioRepository.save(entity);
    }

    public Page<DadosBancarioDto> buscaTodos(String filter, Pageable pageable) {
        Page<DadosBancario> dadosBancarioPage = dadosBancarioRepository.findAll(filter, DadosBancario.class, pageable);

        if (dadosBancarioPage.isEmpty()){
            throw new NotFoundException("Dados bancarios não encontrado");
        }

        return dadosBancarioPage.map(DadosBancarioDto::fromEntity);
    }

    public DadosBancario buscaPorId(Long id) {
        return dadosBancarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Dado bancário não encontrado"));
    }

    public DadosBancario alterar(Long id, DadosBancario alterado) {
        Optional<DadosBancario> encontrado = dadosBancarioRepository.findById(id);

        if ((encontrado.isPresent())) {
            DadosBancario dadosBancario = encontrado.get();
            modelMapper.map(alterado, dadosBancario);
            return dadosBancarioRepository.save(dadosBancario);
        }

        throw new NotFoundException("Dado bancário não encontrado");
    }

    public void remover(Long id) {
        dadosBancarioRepository.deleteById(id);
    }
}
