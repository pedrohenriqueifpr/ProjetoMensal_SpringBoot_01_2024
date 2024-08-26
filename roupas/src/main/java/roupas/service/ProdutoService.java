package roupas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import roupas.entity.Produto;
import roupas.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public String save(Produto produto) {
        produtoRepository.save(produto);
        return "Produto salvo com sucesso";
    }

    public String update(Produto produto, long id) {
        produto.setId(id);
        produtoRepository.save(produto);
        return "Produto atualizado com sucesso";
    }

    public String delete(long id) {
        produtoRepository.deleteById(id);
        return "Produto deletado com sucesso";
    }

    public Produto findById(long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public List<Produto> findByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    public List<Produto> findByValor(Double valor) {
        return produtoRepository.findByValor(valor);
    }

    public List<Produto> findProdutosMaisVendidos() {
        return produtoRepository.findProdutosMaisVendidos();
    }
}
