package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.enterprise.CustomQuerydslPredicateExecutor;
import com.senac.gestaocurso.models.domain.Frequencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FrequenciaRepository extends JpaRepository<Frequencia, Long>, CustomQuerydslPredicateExecutor<Frequencia> {
    Optional<Frequencia> findByAulaIdAndAlunoId(Long aulaId, Long alunoId);
}
