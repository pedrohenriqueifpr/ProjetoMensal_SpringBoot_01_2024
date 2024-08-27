package roupas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import roupas.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByClienteId(Long clienteId);

    List<Venda> findByFuncionarioId(Long funcionarioId);

    @Query("SELECT v FROM Venda v WHERE v.dataVenda = :dataVenda")
    List<Venda> findByDataVenda(@Param("dataVenda") LocalDate dataVenda);
}
