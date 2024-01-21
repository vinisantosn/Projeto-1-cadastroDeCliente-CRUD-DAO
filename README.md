# Projeto CRUD de Clientes

Este projeto implementa um sistema CRUD (Create, Read, Update, Delete) para gerenciar clientes. Ele utiliza duas implementações diferentes de DAO (Data Access Object) para armazenar e manipular os dados dos clientes: `ClienteMapDAO` e `ClienteSetDAO`. Ambas implementam a interface `IClienteDAO`.

## IClienteDAO

A interface `IClienteDAO` define os métodos padrão para interação com os dados dos clientes.

```java
public interface IClienteDAO {

    // Create (inserir novo cliente)
    Boolean cadastrarCliente(Cliente cliente);

    // Read (recuperar cliente por CPF)
    Cliente obterClientePorCpf(String cpf);

    // Read (recuperar todos os clientes)
    Collection<Cliente> obterTodosClientes();

    // Update (atualizar informações do cliente)
    void atualizarCliente(Cliente cliente);

    // Delete (remover cliente por CPF)
    void removerCliente(Long cpf);
}
```

## ClienteMapDAO

A classe `ClienteMapDAO` implementa a interface `IClienteDAO` utilizando um `HashMap` para armazenar os clientes.

```java
public class ClienteMapDAO implements IClienteDAO {
    // ... (código omitido para brevidade)
}
```

## ClienteSetDAO

A classe `ClienteSetDAO` implementa a interface `IClienteDAO` utilizando um `HashSet` para armazenar os clientes.

```java
public class ClienteSetDAO implements IClienteDAO {
    // ... (código omitido para brevidade)
}
```

## Cliente

A classe `Cliente` representa a entidade Cliente com seus atributos e métodos de acesso.

```java
public class Cliente {
    // ... (código omitido para brevidade)
}
```

Ambas as implementações do DAO possuem métodos para cada operação do CRUD, permitindo a manipulação eficiente dos dados dos clientes.

## Exemplo de Uso

Aqui está um exemplo simples de como utilizar as implementações do DAO:

```java
public class Main {
    public static void main(String[] args) {
        // Exemplo de uso do ClienteMapDAO
        IClienteDAO clienteMapDAO = new ClienteMapDAO();
        Cliente cliente1 = new Cliente("João", 123456789L, "123456789", "Rua A", "joao@email.com");
        clienteMapDAO.cadastrarCliente(cliente1);

        // Exemplo de uso do ClienteSetDAO
        IClienteDAO clienteSetDAO = new ClienteSetDAO();
        Cliente cliente2 = new Cliente("Maria", 987654321L, "987654321", "Rua B", "maria@email.com");
        clienteSetDAO.cadastrarCliente(cliente2);
    }
}
```

Este projeto fornece uma estrutura básica para operações CRUD em uma entidade de cliente. Você pode expandir e personalizar conforme necessário para atender aos requisitos específicos do seu projeto.
