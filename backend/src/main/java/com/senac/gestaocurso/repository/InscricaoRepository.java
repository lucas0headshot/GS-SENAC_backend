package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.models.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
}
