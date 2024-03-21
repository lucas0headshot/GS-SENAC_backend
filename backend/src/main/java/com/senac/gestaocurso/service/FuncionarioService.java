package com.senac.gestaocurso.service;



import com.senac.gestaocurso.enterprise.exception.BusinessException;
import com.senac.gestaocurso.enterprise.exception.ValidationException;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;



@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;



    private Boolean validateEntries(Funcionario funcionario) throws ValidationException, BusinessException {
        if (repository.findByCpf(funcionario.getCpf()).isPresent()) {
            throw new ValidationException("CPF existente");
        }

        if (repository.findByRg(funcionario.getRg()).isPresent()) {
            throw new ValidationException("RG existente");
        }

        if (repository.findByTituloEleitor(funcionario.getTituloEleitor()).isPresent()) {
            throw new ValidationException("Título de eleitor existente");
        }

        if (repository.findByPisPasep(funcionario.getPisPasep()).isPresent()) {
            throw new ValidationException("PIS existente");
        }

        if (repository.findByCnh(funcionario.getCnh()).isPresent()) {
            throw new ValidationException("CNH existente");
        }

        if (repository.findByMatricula(funcionario.getMatricula()).isPresent()) {
            throw new ValidationException("Matrícula existente");
        }

        return true;
    }



    public Funcionario salvar(Funcionario entity) {
        if(validateEntries(entity)) {
            return repository.save(entity);
        }

        return null;
    }



    public Page<Funcionario> buscaTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Funcionario buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }



    public Funcionario alterar(Long id, Funcionario alterado) {
        if (validateEntries(alterado)) {
            Optional<Funcionario> encontrado = repository.findById(id);

            if ((encontrado.isPresent())) {
                Funcionario funcionario = encontrado.get();
                funcionario.setEmail(alterado.getEmail());
                funcionario.setNome(alterado.getNome());
                funcionario.setEndereco(alterado.getEndereco());
                funcionario.setCargo(alterado.getCargo());
                funcionario.setCnh(alterado.getCnh());
                funcionario.setAreaAtuacao(alterado.getAreaAtuacao());
                funcionario.setCpf(alterado.getCpf());
                funcionario.setCargaHoraria(alterado.getCargaHoraria());
                funcionario.setDadosBancarios(alterado.getDadosBancarios());
                funcionario.setCtbs(alterado.getCtbs());
                funcionario.setCertificacoes(alterado.getCertificacoes());
                funcionario.setExpAnteriores(alterado.getExpAnteriores());
                funcionario.setDependentes(alterado.getDependentes());
                funcionario.setTituloEleitor(alterado.getTituloEleitor());
                funcionario.setTipoRH(alterado.getTipoRH());
                funcionario.setTelefone(alterado.getTelefone());
                funcionario.setReservista(alterado.getReservista());
                funcionario.setStatus(alterado.getStatus());
                funcionario.setRg(alterado.getRg());
                funcionario.setSalarioContratual(alterado.getSalarioContratual());
                funcionario.setModalidadeContratual(alterado.getModalidadeContratual());
                funcionario.setDataNasc(alterado.getDataNasc());
                funcionario.setPisPasep(alterado.getPisPasep());
                funcionario.setRegistroProfissional(alterado.getRegistroProfissional());
                funcionario.setSindicato(alterado.getSindicato());
                funcionario.setSetor(alterado.getSetor());
                funcionario.setDataAdmissao(alterado.getDataAdmissao());
                funcionario.setFiliacao(alterado.getFiliacao());
                funcionario.setRacaCor(alterado.getRacaCor());
                funcionario.setReligiao(alterado.getReligiao());
                funcionario.setDoadorSangue(alterado.getDoadorSangue());
                funcionario.setGenero(alterado.getGenero());
                funcionario.setTurno(alterado.getTurno());
                funcionario.setNacionalidade(alterado.getNacionalidade());
                funcionario.setRedeSocial(alterado.getRedeSocial());
                funcionario.setMatricula(alterado.getMatricula());
                funcionario.setIdioma(alterado.getIdioma());
                funcionario.setHoraExtra(alterado.getHoraExtra());
                funcionario.setHoraEntrada(alterado.getHoraEntrada());
                funcionario.setHoraSaida(alterado.getHoraSaida());
                funcionario.setEstadoCivil(alterado.getEstadoCivil());
                funcionario.setEscolaridade(alterado.getEscolaridade());

                return repository.save(funcionario);
            }
        }

        return null;
    }



    public void remover(Long id) {
        repository.deleteById(id);
    }
}