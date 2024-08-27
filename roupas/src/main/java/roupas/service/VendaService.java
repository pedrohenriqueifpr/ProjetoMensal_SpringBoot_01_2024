package roupas.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
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
        Cliente cliente = clienteRepository.findById(venda.getCliente().getId()).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        
        Funcionario funcionario = funcionarioRepository.findById(venda.getFuncionario().getId()).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        List<Produto> produtos = venda.getProdutos().stream().map(produto -> produtoRepository.findById(produto.getId()).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"))).collect(Collectors.toList());

        venda.setCliente(cliente);
        venda.setFuncionario(funcionario);
        venda.setProdutos(produtos);
        venda.setDataVenda(LocalDate.now());
    	
    	double valorTotal = venda.getProdutos().stream().mapToDouble(Produto::getValor).sum();
        venda.setValorTotal(valorTotal);
        
        vendaRepository.save(venda);
        return "Venda salva com sucesso";
    }

    public String update(Venda venda, long id) {
    	Cliente cliente = clienteRepository.findById(venda.getCliente().getId()).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        
        Funcionario funcionario = funcionarioRepository.findById(venda.getFuncionario().getId()).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        List<Produto> produtos = venda.getProdutos().stream().map(produto -> produtoRepository.findById(produto.getId()).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"))).collect(Collectors.toList());

        venda.setCliente(cliente);
        venda.setFuncionario(funcionario);
        venda.setProdutos(produtos);
        venda.setDataVenda(LocalDate.now());
    	
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
