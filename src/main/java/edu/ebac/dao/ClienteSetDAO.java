package edu.ebac.dao;

import edu.ebac.domain.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClienteSetDAO implements IClienteDAO{
    private Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrarCliente(Cliente cliente) {

        return this.set.add(cliente);
    }

    @Override
    public Cliente obterClientePorCpf(String cpf) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente: this.set
             ) {
            if(cliente.getCpf().equals(cpf)){
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado!=null)
            return clienteEncontrado;
        else
            return null;
    }



    @Override
    public Collection<Cliente> obterTodosClientes() {
        return this.set;
    }

    @Override
    public void atualizarCliente(Cliente cliente) {
        if (this.set.contains(cliente)){
            for (Cliente clienteCadastrado: this.set){
                if (clienteCadastrado.equals(cliente)){
                    clienteCadastrado.setNome(cliente.getNome());
                    clienteCadastrado.setCpf(cliente.getCpf());
                    clienteCadastrado.setTelefone(cliente.getTelefone());
                    clienteCadastrado.setEndereco(cliente.getEndereco());
                    clienteCadastrado.setEmail(cliente.getEmail());
                    break;
                }
            }
        }

    }

    @Override
    public void removerCliente(Long cpf) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente:this.set
             ) {
            if (cliente.getCpf().equals(cpf)){
                clienteEncontrado = cliente;
                break;
            }
        }
        if (clienteEncontrado!=null){
            this.set.remove(clienteEncontrado);
        }

    }
}
