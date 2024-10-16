package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.enterprise.CustomQuerydslPredicateExecutor;
import com.senac.gestaocurso.models.domain.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface InscricaoRepository extends JpaRepository<Inscricao, Long>, CustomQuerydslPredicateExecutor<Inscricao> {
        Inscricao findByInscritoId(Long inscritoId);
}
