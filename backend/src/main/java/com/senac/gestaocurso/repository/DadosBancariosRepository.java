package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.enterprise.CustomQuerydslPredicateExecutor;
import com.senac.gestaocurso.models.DadosBancario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosBancariosRepository extends JpaRepository <DadosBancario, Long>, CustomQuerydslPredicateExecutor<DadosBancario> {
}
