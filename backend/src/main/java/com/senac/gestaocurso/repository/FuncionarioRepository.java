package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.enterprise.CustomQuerydslPredicateExecutor;
import com.senac.gestaocurso.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario, Long>, CustomQuerydslPredicateExecutor<Funcionario> {
    Funcionario findByCpf(String cpf);
    Funcionario findByRg(String rg);
    Funcionario findByCtbs(String ctbs);
    Funcionario findByTelefone(String telefone);
    Funcionario findByTituloEleitor(String titulo);
    Funcionario findByReservista(String reservista);
    Funcionario findByPisPasep(String pispasep);
    Funcionario findByEmail(String email);
    Funcionario findByCnh(String cnh);
    Funcionario findByMatricula(String matricula);
}
