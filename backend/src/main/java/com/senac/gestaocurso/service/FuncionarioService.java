package com.senac.gestaocurso.service;



import com.senac.gestaocurso.enterprise.exception.BusinessException;
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
    private FuncionarioRepository funcionarioRepository;
  
  
  
    public Funcionario salvar(Funcionario entity) {
        if (funcionarioRepository.findByCpf(entity.getCpf()).isPresent()) { // CPF já cadastrado
            throw new BusinessException("CPF já cadastrado");
        }

        return funcionarioRepository.save(entity);
    }

  
  
    public Page<Funcionario> buscaTodos(Pageable pageable) {
        return funcionarioRepository.findAll(pageable);
    }



    public Page<Funcionario> buscaTodos(Pageable pageable) {
        return funcionarioRepository.findAll(pageable);
    }

    public Funcionario buscaPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }



    public Funcionario alterar(Long id, Funcionario alterado) {
        Optional<Funcionario> encontrado = funcionarioRepository.findById(id);
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
            funcionario.setDadosBancarioses(alterado.getDadosBancarioses());
            funcionario.setCtbs(alterado.getCtbs());
            funcionario.setCertificacoeses(alterado.getCertificacoeses());
            funcionario.setExpAnteriors(alterado.getExpAnteriors());
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

            return funcionarioRepository.save(funcionario);
        }
        return null;
    }



    public void remover(Long id) {
        funcionarioRepository.deleteById(id);
    }
}