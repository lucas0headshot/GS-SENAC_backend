package com.senac.gestaocurso.service;

import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.domain.Inscricao;
import com.senac.gestaocurso.repository.InscricaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class InscricaoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InscricaoRepository inscricaoRepository;

    public Inscricao salvar(Inscricao entity) {
        return inscricaoRepository.save(entity);
    }

    public Page<Inscricao> buscaTodos(Pageable pageable) {
        var list = inscricaoRepository.findAll(pageable);

        if (list.isEmpty()){
            throw new NotFoundException("Nenhuma inscrição encontrada");
        }

        return list;
    }

    public Inscricao buscaPorId(Long id) {
        return inscricaoRepository.findById(id).orElseThrow(() -> new NotFoundException("Inscrição não encontrada"));
    }

    public Inscricao alterar(Long id, Inscricao alterado) {
        Optional<Inscricao> encontrado = inscricaoRepository.findById(id);
        if (encontrado.isPresent()) {
            Inscricao inscricao = encontrado.get();
            modelMapper.map(alterado, inscricao);
            return inscricaoRepository.save(inscricao);
        }
        throw new NotFoundException("Inscriçãonão encontrada");
    }

    public void remover(Long id) {
        inscricaoRepository.deleteById(id);
    }
}