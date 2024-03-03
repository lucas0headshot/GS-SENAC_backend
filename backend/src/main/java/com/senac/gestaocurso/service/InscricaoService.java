package com.senac.gestaocurso.service;

import com.senac.gestaocurso.models.Inscricao;
import com.senac.gestaocurso.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;
    public Inscricao salvar(Inscricao entity) {return inscricaoRepository.save(entity);}
    public List<Inscricao> buscaTodos() {return inscricaoRepository.findAll();}
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
            return inscricaoRepository.save(inscricao);
        }
        return null;
    }
    public void remover(Long id) {inscricaoRepository.deleteById(id);
    }
}