package com.senac.gestaocurso.repository;



import com.senac.gestaocurso.models.Chamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Long> {
}