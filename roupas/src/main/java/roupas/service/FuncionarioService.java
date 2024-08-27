package roupas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import roupas.entity.Funcionario;
import roupas.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public String save(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return "Funcionário salvo com sucesso";
    }

    public String update(Funcionario funcionario, long id) {
        funcionario.setId(id);
        funcionarioRepository.save(funcionario);
        return "Funcionário atualizado com sucesso";
    }

    public String delete(long id) {
        funcionarioRepository.deleteById(id);
        return "Funcionário deletado com sucesso";
    }

    public Funcionario findById(long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public List<Funcionario> findByNome(String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    public Funcionario findByMatricula(String matricula) {
        return funcionarioRepository.findByMatricula(matricula);
    }

    public List<Funcionario> findByFaixaEtaria(int idadeMin, int idadeMax) {
        return funcionarioRepository.findByFaixaEtaria(idadeMin, idadeMax);
    }
}
