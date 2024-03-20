package com.senac.gestaocurso.repository;



import com.senac.gestaocurso.models.Inscricao;
import com.senac.gestaocurso.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;



@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    List<Inscricao> findAllByTurma(Turma turma);
}