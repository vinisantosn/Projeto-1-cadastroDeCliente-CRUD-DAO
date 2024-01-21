package edu.ebac.dao;

import edu.ebac.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO{
    Map<Long, Cliente> map;

    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrarCliente(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf()))
            return false;
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public Cliente obterClientePorCpf(String cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> obterTodosClientes() {
        return this.map.values();
    }

    @Override
    public void atualizarCliente(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        if(clienteCadastrado!=null){

            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setCpf(cliente.getCpf());
            clienteCadastrado.setTelefone(cliente.getTelefone());
            clienteCadastrado.setEndereco(cliente.getEndereco());
            clienteCadastrado.setEmail(cliente.getEmail());
        }

    }

    @Override
    public void removerCliente(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);
        if(clienteCadastrado!=null)
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);

    }
}
