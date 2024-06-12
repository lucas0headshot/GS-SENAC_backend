package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.enterprise.CustomQuerydslPredicateExecutor;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.models.domain.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long>, CustomQuerydslPredicateExecutor<Aula> {
    Aula findByDia(LocalDate dia);
}
