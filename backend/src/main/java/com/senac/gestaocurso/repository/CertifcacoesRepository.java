package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.enterprise.CustomQuerydslPredicateExecutor;
import com.senac.gestaocurso.models.Certificacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertifcacoesRepository extends JpaRepository<Certificacoes, Long>, CustomQuerydslPredicateExecutor<Certificacoes> {
}
