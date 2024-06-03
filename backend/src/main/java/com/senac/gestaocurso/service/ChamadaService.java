package com.senac.gestaocurso.service;



import com.senac.gestaocurso.models.Chamada;
import com.senac.gestaocurso.repository.ChamadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.awt.print.Pageable;
import java.util.Optional;


@Service
public class ChamadaService {
    @Autowired
    private ChamadaRepository repository;



    public Chamada salvar(Chamada chamada) {
        return repository.save(chamada);
    }



    public Page<Chamada> buscaTodos(Pageable pageable) {
        return repository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    public Chamada buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }



    public Chamada alterar(Long id, Chamada chamada) {
        Optional<Chamada> alterado = repository.findById(id);

        if (alterado.isPresent()) {
            var encontrado = alterado.get();

            chamada.setFrequencias(encontrado.getFrequencias());
            chamada.setProfessor(encontrado.getProfessor());

            return repository.save(chamada);
        }

        return null;
    }



    public void remover(Long id) {
        repository.deleteById(id);
    }
}