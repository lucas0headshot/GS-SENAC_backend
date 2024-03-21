package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
    Optional<Funcionario> findByCpf(String cpf);

    Optional<Funcionario> findByRg(String rg);

    Optional<Funcionario> findByTituloEleitor(String tituloEleitor);

    Optional<Funcionario> findByPisPasep(String pisPasep);

    Optional<Funcionario> findByCnh(String cnh);

    Optional<Funcionario> findByMatricula(String matricula);
}
