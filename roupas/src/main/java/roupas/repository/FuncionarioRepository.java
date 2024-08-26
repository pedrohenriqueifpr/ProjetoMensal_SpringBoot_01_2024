package roupas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import roupas.entity.Funcionario;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByNome(String nome);

    Funcionario findByMatricula(String matricula);

    @Query("SELECT f FROM Funcionario f WHERE f.idade BETWEEN :idadeMin AND :idadeMax")
    List<Funcionario> findByFaixaEtaria(@Param("idadeMin") int idadeMin, @Param("idadeMax") int idadeMax);
}
