package edu.ebac.dao;

import edu.ebac.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {


    // Create (inserir novo cliente)
    Boolean cadastrarCliente(Cliente cliente);

    // Read (recuperar cliente por ID)
    Cliente obterClientePorCpf(String cpf);

    // Read (recuperar todos os clientes)
    Collection<Cliente> obterTodosClientes();

    // Update (atualizar informações do cliente)
    void atualizarCliente(Cliente cliente);

    // Delete (remover cliente por ID)
    void removerCliente(Long cpf);
}
