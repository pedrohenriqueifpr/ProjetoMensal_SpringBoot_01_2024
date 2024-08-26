package roupas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import roupas.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente,Long> {

    List<Cliente> findByNome(String nome);

    Cliente findByCpf(String cpf);

    @Query("SELECT c FROM Cliente c WHERE c.telefone LIKE CONCAT('+', :codigoArea, '%')")
    List<Cliente> findByCodigoArea(@Param("codigoArea") String codigoArea);	
}
