package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.models.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {
}
