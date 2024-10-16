package com.senac.gestaocurso.service;

import com.senac.gestaocurso.dto.InscricaoDto;
import com.senac.gestaocurso.enterprise.exception.OkNoContent;
import com.senac.gestaocurso.models.domain.Inscricao;
import com.senac.gestaocurso.repository.InscricaoRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoInscricaoStrategy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscricaoService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private List<NovaValidacaoInscricaoStrategy> validacaoInscricaoStrategies;

    public Inscricao salvar(Inscricao entity) {
        validacaoInscricaoStrategies.forEach(validation -> validation.validar(entity));
        Inscricao inscricao = Inscricao.Builder.builder()
                .data(entity.getData())
                .status(entity.getStatus())
                .valor(entity.getValor())
                .curso(entity.getCurso())
                .inscrito(entity.getInscrito())
                .build();
        return inscricaoRepository.save(inscricao);
    }

    public Page<InscricaoDto> buscaTodos(String filter, Pageable pageable) {
        Page<Inscricao> inscricaoPage = inscricaoRepository.findAll(filter, Inscricao.class, pageable);

        if (inscricaoPage.isEmpty()){
            throw new OkNoContent("Nenhuma Inscrição encontrada");
        }

        return inscricaoPage.map(InscricaoDto::fromEntity);
    }

    public Inscricao buscaPorId(Long id) {
        return inscricaoRepository.findById(id).orElseThrow(() -> new OkNoContent("Inscrição não encontrada"));
    }

    public Inscricao alterar(Long id, Inscricao alterado) {
        Optional<Inscricao> encontrado = inscricaoRepository.findById(id);

        if (encontrado.isPresent()) {
            Inscricao inscricao = encontrado.get();
            modelMapper.map(alterado, inscricao);
            return inscricaoRepository.save(inscricao);
        }

        throw new OkNoContent("Inscrição não encontrada");
    }

    public void remover(Long id) {
        inscricaoRepository.deleteById(id);
    }
}
