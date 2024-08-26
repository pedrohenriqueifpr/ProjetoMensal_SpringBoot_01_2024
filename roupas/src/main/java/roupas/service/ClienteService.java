package roupas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import roupas.entity.Cliente;
import roupas.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public String save(Cliente cliente) {
        clienteRepository.save(cliente);
        return "Cliente salvo com sucesso";
    }

    public String update(Cliente cliente, long id) {
        cliente.setId(id);
        clienteRepository.save(cliente);
        return "Cliente atualizado com sucesso";
    }

    public String delete(long id) {
        clienteRepository.deleteById(id);
        return "Cliente deletado com sucesso";
    }

    public Cliente findById(long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public List<Cliente> findByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    public Cliente findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public List<Cliente> findClientesByCodigoArea(String codigoArea) {
        return clienteRepository.findByCodigoArea(codigoArea);
    }
}
