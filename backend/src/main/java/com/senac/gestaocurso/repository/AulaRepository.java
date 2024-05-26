package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.enterprise.CustomQuerydslPredicateExecutor;
import com.senac.gestaocurso.models.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long>, CustomQuerydslPredicateExecutor<Aula> {

    Aula findByMateria(Long idMateria);
    Aula findByDia(LocalDate dia);
    Aula findByProfessor(Long idProfessor);
}
