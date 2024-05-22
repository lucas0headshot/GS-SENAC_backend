package com.senac.gestaocurso.service;


import com.senac.gestaocurso.models.Cargo;
import com.senac.gestaocurso.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;
    public Cargo salvar(Cargo entity) {
        return cargoRepository.save(entity);
    }
    public Page<Cargo> buscaTodos(Pageable pageable) {
        return cargoRepository.findAll(pageable);
    }
    public Cargo buscaPorId(Long id) {
        return cargoRepository.findById(id).orElse(null);
    }
    public Cargo alterar(Long id, Cargo alterado) {
        Optional<Cargo> encontrado = cargoRepository.findById(id);
        if ((encontrado.isPresent())) {
            Cargo cargo = encontrado.get();
            cargo.setDescricao(alterado.getDescricao());
            cargo.setNivel(alterado.getNivel());
            cargo.setComissionado(alterado.getComissionado());
            return cargoRepository.save(cargo);
        }
        return null;
    }
    public void remover(Long id) {cargoRepository.deleteById(id);
    }
}
