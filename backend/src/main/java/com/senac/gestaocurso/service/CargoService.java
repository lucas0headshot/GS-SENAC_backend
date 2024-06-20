package com.senac.gestaocurso.service;


import com.senac.gestaocurso.enterprise.exception.NotFoundException;
import com.senac.gestaocurso.models.Cargo;
import com.senac.gestaocurso.repository.CargoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CargoRepository cargoRepository;
    public Cargo salvar(Cargo entity) {
        return cargoRepository.save(entity);
    }
    public Page<Cargo> buscaTodos(Pageable pageable) {
        var list = cargoRepository.findAll(pageable);
        if (list.isEmpty()){
            throw new NotFoundException("nenhum cargo encontrado");
        }
        return list;
    }
    public Cargo buscaPorId(Long id) {
        return cargoRepository.findById(id).orElseThrow(() -> new NotFoundException("cargo não encontrado"));
    }
    public Cargo alterar(Long id, Cargo alterado) {
        Optional<Cargo> encontrado = cargoRepository.findById(id);
        if (encontrado.isPresent()) {
            Cargo cargo = encontrado.get();
            modelMapper.map(alterado, cargo);
            return cargoRepository.save(cargo);
        }
        throw new NotFoundException("cargo não encontrado");
    }
    public void remover(Long id) {
        cargoRepository.deleteById(id);
    }
}
