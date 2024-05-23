package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.enterprise.CustomQuerydslPredicateExecutor;
import com.senac.gestaocurso.models.ExpAnterior;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpAnteriorRepository extends JpaRepository<ExpAnterior, Long>, CustomQuerydslPredicateExecutor<ExpAnterior> {
}
