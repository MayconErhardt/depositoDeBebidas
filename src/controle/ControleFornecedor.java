/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Fornecedor;

/**
 *
 * @author Maycon
 */
public class ControleFornecedor {

    public void gravarNovo(Fornecedor Novo) {
        // Identificador para objeto que gerencia uma entidade(acesso ao banco)
        EntityManager gerente = fabrica.gerente.criarGerente();

        // gravar o objeto cliente recebido como parâmetro no banco de dados
        // iniciar transação
        gerente.getTransaction().begin();

        // persistir o objeto no banco
        gerente.persist(Novo);

        // fazer um commit (salvar realmente no banco) na transação
        gerente.getTransaction().commit();

        // finalizar a conexão
        gerente.close();

    }

    public List<Fornecedor> listarTodos() {
        // lista de usuários a ser retornada
        List<Fornecedor> listaUsuarios;

        // criar uma conexão com o banco - gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // Criar um identificar para uma consulta SQL
        TypedQuery<Fornecedor> consultaUsuarios;

        // criar a consulta 
        consultaUsuarios = gerente.createNamedQuery("Fornecedor.findAll", Fornecedor.class);

        // pegar o resultado da consulta realizada
        listaUsuarios = consultaUsuarios.getResultList();

        return listaUsuarios;
    }

    public void salvarAlteracao(Fornecedor fornecedor) {
        // criar um gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // iniciar uma transação com o banco
        gerente.getTransaction().begin();

        //salvar a alteração no banco de dados
        // merge sobrepõe um registro no banco de dados com base na 
        //chave primária da entidade
        gerente.merge(fornecedor);

        // finalizar a transação com o banco
        gerente.getTransaction().commit();

        // fecho a conexão
        gerente.close();

    }

    public List<Fornecedor> listarPorNome(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Fornecedor> consulta
                = gerente.createNamedQuery("Fornecedor.findByFornecedorNome", Fornecedor.class);

        consulta.setParameter("forNome", "%" + nomeProcurar + "%");

        return consulta.getResultList();
    }

    public List<Fornecedor> listarPorCPF(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Fornecedor> consulta
                = gerente.createNamedQuery("Fornecedor.findByClienteCPF", Fornecedor.class);

        consulta.setParameter("cliCPF", "%" + nomeProcurar + "%");

        return consulta.getResultList();
    }

    public void excluir(int codigo) throws NaoExisteException,IntegridadeException{

        // cria uma conexão com o banco
        EntityManager gerente = fabrica.gerente.criarGerente();

        // criando um identificador para um objeto usuário
        Fornecedor forne;

        // pego o usuário que possui o código passado do banco de
        // dados
        forne = gerente.find(Fornecedor.class, codigo);

        // se o usuário não foi encontrado
        if (forne == null) {
            throw new NaoExisteException("Este Fornecedor não existe");
        } else {
            try {

                // inicia uma transação
                gerente.getTransaction().begin();

                //excluir o usuário do banco de dados
                gerente.remove(forne);

                // finaliza a transação
                gerente.getTransaction().commit();

                // fechar a conexão
                gerente.close();
            } catch (Exception e) {
                throw new IntegridadeException("Não foi possível excluir o fornecedor: " + forne.getFornecedorNomeFantasia()+ " ");
            }
        }

    }

    public List<Fornecedor> CPFIgual(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Fornecedor> consulta
                = gerente.createNamedQuery("Cliente.findByClienteCPFIgual", Fornecedor.class);

        consulta.setParameter("cliCPF", nomeProcurar);

        return consulta.getResultList();
    }

    public List<Fornecedor> buscarEmail(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Fornecedor> consulta
                = gerente.createNamedQuery("Fornecedor.findByFornecedorEmailIgual", Fornecedor.class);

        consulta.setParameter("forEmail", nomeProcurar);

        return consulta.getResultList();
    }
}
