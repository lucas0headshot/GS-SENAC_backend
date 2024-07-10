package com.senac.gestaocurso.service;

import com.senac.gestaocurso.dto.CargoDto;
import com.senac.gestaocurso.enterprise.exception.OkNoContent;
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

    public Page<CargoDto> buscaTodos(String filter, Pageable pageable) {
        Page<Cargo> cargoPage = cargoRepository.findAll(filter, Cargo.class, pageable);

        if (cargoPage.isEmpty()){
            throw new OkNoContent("Nenhum cargo encontrado");
        }

        return cargoPage.map(CargoDto::fromEntity);
    }

    public Cargo buscaPorId(Long id) {
        return cargoRepository.findById(id).orElseThrow(() -> new OkNoContent("cargo não encontrado"));
    }

    public Cargo alterar(Long id, Cargo alterado) {
        Optional<Cargo> encontrado = cargoRepository.findById(id);

        if (encontrado.isPresent()) {
            Cargo cargo = encontrado.get();
            modelMapper.map(alterado, cargo);
            return cargoRepository.save(cargo);
        }

        throw new OkNoContent("cargo não encontrado");
    }

    public void remover(Long id) {
        cargoRepository.deleteById(id);
    }
}
