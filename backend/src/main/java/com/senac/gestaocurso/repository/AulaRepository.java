package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.enterprise.CustomQuerydslPredicateExecutor;
import com.senac.gestaocurso.models.domain.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long>, CustomQuerydslPredicateExecutor<Aula> {
    Aula findByDia(LocalDate dia);
    List<Aula> findByMateriaId(Long id);
}
