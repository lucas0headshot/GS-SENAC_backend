package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.enterprise.CustomQuerydslPredicateExecutor;
import com.senac.gestaocurso.models.Dependentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentesRepository extends JpaRepository<Dependentes, Long>, CustomQuerydslPredicateExecutor<Dependentes> {
}
