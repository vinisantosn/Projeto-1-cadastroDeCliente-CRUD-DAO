package edu.ebac;

import edu.ebac.dao.ClienteMapDAO;
import edu.ebac.dao.IClienteDAO;
import edu.ebac.domain.Cliente;

import javax.swing.*;

public class App {
    private static IClienteDAO iClienteDAO;
    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();
        String opcao = JOptionPane.showInputDialog(null,
                "DIGITE A OPÇÃO DESEJADA: \n\t1 - CADASTRAR\n\t2 - CONSULTAR\n\t3 - DELETAR\n\t" +
                        "4 - ALTERAR\n\t5 - SAIR", "CADASTRO DE CLIENTES",JOptionPane.INFORMATION_MESSAGE);
        while(!isOpcaoValida(opcao)){
            if ("".equals(opcao)) sair();
            opcao = JOptionPane.showInputDialog(null,
                    "DIGITE A OPÇÃO DESEJADA: \n\t1 - CADASTRAR\n\t2 - CONSULTAR\n\t3 - DELETAR\n\t" +
                            "4 - ALTERAR\n\t5 - SAIR", "CADASTRO DE CLIENTES",JOptionPane.INFORMATION_MESSAGE);
        }
        while (isOpcaoValida(opcao)){
            if (isOpcaoSair(opcao)){
                sair();
            } else if (isOpcaoCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente " +
                        "separados por virgula. EX.: nome, cpf, telefone, endereço, email", "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
                
            } else if (isOpcaoConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF do cliente: " , JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);

            }

            opcao = JOptionPane.showInputDialog(null,
                    "DIGITE A OPÇÃO DESEJADA: \n\t1 - CADASTRAR\n\t2 - CONSULTAR\n\t3 - DELETAR\n\t" +
                            "4 - ALTERAR\n\t5 - SAIR", "CADASTRO DE CLIENTES",JOptionPane.INFORMATION_MESSAGE);


        }
    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.obterClientePorCpf(dados);
        JOptionPane.showMessageDialog(null, "Cliente encontrado: "+ cliente.toString(), "Confirmação de cadastro", JOptionPane.INFORMATION_MESSAGE);

    }

    private static boolean isOpcaoConsultar(String opcao) {
        switch (opcao){
            case "2":
                return true;
            default:
                return false;

        }
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0],Long.parseLong(dadosSeparados[1]),dadosSeparados[2],dadosSeparados[3],dadosSeparados[4]);
        Boolean isCadastrado = iClienteDAO.cadastrarCliente(cliente);
        if(isCadastrado){
            JOptionPane.showMessageDialog(null, "Cliente cadastro com sucesso", "Confirmação de cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "ERRO ao cadastrar o cliente", "Confirmação de cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isOpcaoCadastro(String opcao) {
        switch (opcao){
            case "1":
                return true;
            default:
                return false;

        }
    }

    private static boolean isOpcaoSair(String opcao) {
        switch (opcao){
            case "5":
                return true;
            default:
                return false;

        }

    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Fechando o programa...", "SAIR", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        switch (opcao){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                return true;
            default:
                return false;

        }
    }
}
