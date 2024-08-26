package roupas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import roupas.entity.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNome(String nome);

    List<Produto> findByValor(Double valor);

    @Query("SELECT p FROM Produto p JOIN p.vendas v GROUP BY p.id ORDER BY COUNT(v) DESC")
    List<Produto> findProdutosMaisVendidos();
}
