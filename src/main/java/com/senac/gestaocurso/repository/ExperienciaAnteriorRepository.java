package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.enterprise.CustomQuerydslPredicateExecutor;
import com.senac.gestaocurso.models.ExperienciaAnterior;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienciaAnteriorRepository extends JpaRepository<ExperienciaAnterior, Long>, CustomQuerydslPredicateExecutor<ExperienciaAnterior> {
}
