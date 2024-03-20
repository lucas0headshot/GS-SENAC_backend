package com.senac.gestaocurso.service;


import com.senac.gestaocurso.models.Avaliacao;
import com.senac.gestaocurso.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;



@Service
public class AvaliacaoService {
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;



    public Avaliacao salvar(Avaliacao entity) {
        return avaliacaoRepository.save(entity);
    }



    public Page<Avaliacao> buscaTodos(Pageable pageable) {
        return avaliacaoRepository.findAll(pageable);
    }

    public Avaliacao buscaPorId(Long id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

  
  
    public Avaliacao alterar(Long id, Avaliacao alterado) {
        Optional<Avaliacao> encontrado = avaliacaoRepository.findById(id);
        if (encontrado.isPresent()) {
            var avaliacao = encontrado.get();
            avaliacao.setAluno(alterado.getAluno());
            avaliacao.setData(alterado.getData());
            avaliacao.setMateria(alterado.getMateria());
            avaliacao.setNome(alterado.getNome());
            avaliacao.setNota(avaliacao.getNota());

            return avaliacaoRepository.save(avaliacao);
        }
        return null;
    }

  
  
    public void remover(Long id) {
        avaliacaoRepository.deleteById(id);
    }
}