package roupas.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import roupas.entity.Cliente;
import roupas.entity.Funcionario;
import roupas.entity.Produto;
import roupas.entity.Venda;
import roupas.repository.ClienteRepository;
import roupas.repository.FuncionarioRepository;
import roupas.repository.ProdutoRepository;
import roupas.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public String save(Venda venda) {

        List<Cliente> clientesExistentes = clienteRepository.findByNome(venda.getCliente().getNome());
        if (!clientesExistentes.isEmpty()) {
            venda.setCliente(clientesExistentes.get(0));
        }

        List<Funcionario> funcionariosExistentes = funcionarioRepository.findByNome(venda.getFuncionario().getNome());
        if (!funcionariosExistentes.isEmpty()) {
            venda.setFuncionario(funcionariosExistentes.get(0));
        }

        List<Produto> produtosExistentes = venda.getProdutos();
        for (int i = 0; i < produtosExistentes.size(); i++) {
            Produto produto = produtosExistentes.get(i);
            List<Produto> produtosEncontrados = produtoRepository.findByNome(produto.getNome());
            if (!produtosEncontrados.isEmpty()) {
                produtosExistentes.set(i, produtosEncontrados.get(0));
            }
        }
    	
    	double valorTotal = venda.getProdutos().stream().mapToDouble(Produto::getValor).sum();
        venda.setValorTotal(valorTotal);
        
        vendaRepository.save(venda);
        return "Venda salva com sucesso";
    }

    public String update(Venda venda, long id) {
        List<Cliente> clientesExistentes = clienteRepository.findByNome(venda.getCliente().getNome());
        if (!clientesExistentes.isEmpty()) {
            venda.setCliente(clientesExistentes.get(0));
        }

        List<Funcionario> funcionariosExistentes = funcionarioRepository.findByNome(venda.getFuncionario().getNome());
        if (!funcionariosExistentes.isEmpty()) {
            venda.setFuncionario(funcionariosExistentes.get(0));
        }

        List<Produto> produtosExistentes = venda.getProdutos();
        for (int i = 0; i < produtosExistentes.size(); i++) {
            Produto produto = produtosExistentes.get(i);
            List<Produto> produtosEncontrados = produtoRepository.findByNome(produto.getNome());
            if (!produtosEncontrados.isEmpty()) {
                produtosExistentes.set(i, produtosEncontrados.get(0));
            }
        }
    	
    	double valorTotal = venda.getProdutos().stream().mapToDouble(Produto::getValor).sum();
        venda.setValorTotal(valorTotal);
        
        venda.setId(id);
        vendaRepository.save(venda);
        return "Venda atualizada com sucesso";
    }

    public String delete(long id) {
    	vendaRepository.deleteById(id);
        return "Venda deletada com sucesso";
    }

    public Venda findById(long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public List<Venda> findByClienteId(Long clienteId) {
        return vendaRepository.findByClienteId(clienteId);
    }

    public List<Venda> findByFuncionarioId(Long funcionarioId) {
        return vendaRepository.findByFuncionarioId(funcionarioId);
    }

    public List<Venda> findByDataVenda(LocalDate dataVenda) {
        return vendaRepository.findByDataVenda(dataVenda);
    }
}
