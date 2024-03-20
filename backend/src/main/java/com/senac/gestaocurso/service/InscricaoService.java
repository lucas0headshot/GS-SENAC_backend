package com.senac.gestaocurso.service;


import com.senac.gestaocurso.enterprise.exception.BusinessException;
import com.senac.gestaocurso.models.Inscricao;
import com.senac.gestaocurso.models.Turma;
import com.senac.gestaocurso.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;



@Service
public class InscricaoService {
    @Autowired
    private InscricaoRepository inscricaoRepository;



    private Boolean verificarLimiteInscricoes(Turma turma) {
        List<Inscricao> qtdInscritosTurma = inscricaoRepository.findAllByTurma(turma);

        return qtdInscritosTurma.size() > turma.getLimiteQtdInscricao();
    }



    public Inscricao salvar(Inscricao entity) {
        if (!verificarLimiteInscricoes(entity.getTurma())) {
            throw new BusinessException("Limite de inscrições atingido");
        }

        return inscricaoRepository.save(entity);
    }



    public Page<Inscricao> buscaTodos(Pageable pageable) {
        return inscricaoRepository.findAll(pageable);
    }

    public Inscricao buscaPorId(Long id) {
        return inscricaoRepository.findById(id).orElse(null);
    }



    public Inscricao alterar(Long id, Inscricao alterado) {
        Optional<Inscricao> encontrado = inscricaoRepository.findById(id);
        if ((encontrado.isPresent())) {
            Inscricao inscricao = encontrado.get();
            inscricao.setData(alterado.getData());
            inscricao.setStatus(alterado.getStatus());
            inscricao.setInscrito(alterado.getInscrito());
            inscricao.setValor(alterado.getValor());

            if (!verificarLimiteInscricoes(inscricao.getTurma())) {
                throw new BusinessException("Limite de inscrições atingido");
            }

            return inscricaoRepository.save(inscricao);
        }

        return null;
    }



    public void remover(Long id) {
      inscricaoRepository.deleteById(id);
    }
}