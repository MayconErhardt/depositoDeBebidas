/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Cliente;

/**
 *
 * @author Maycon
 */
public class ControleCliente {

    public void gravarNovo(Cliente Novo) {
        // Identificador para objeto que gerencia uma entidade(acesso ao banco)
        EntityManager gerente = fabrica.gerente.criarGerente();

        // gravar o objeto Cliente recebido como parâmetro no banco de dados
        // iniciar transação
        gerente.getTransaction().begin();

        // persistir o objeto no banco
        gerente.persist(Novo);

        // fazer um commit (salvar realmente no banco) na transação
        gerente.getTransaction().commit();

        // finalizar a conexão
        gerente.close();

    }

    public List<Cliente> listarTodos() {
        // lista de usuários a ser retornada
        List<Cliente> listaUsuarios;

        // criar uma conexão com o banco - gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // Criar um identificar para uma consulta SQL
        TypedQuery<Cliente> consultaUsuarios;

        // criar a consulta 
        consultaUsuarios = gerente.createNamedQuery("Cliente.findAll", Cliente.class);

        // pegar o resultado da consulta realizada
        listaUsuarios = consultaUsuarios.getResultList();

        return listaUsuarios;
    }

    public void salvarAlteracao(Cliente funcionario) {
        // criar um gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // iniciar uma transação com o banco
        gerente.getTransaction().begin();

        //salvar a alteração no banco de dados
        // merge sobrepõe um registro no banco de dados com base na 
        //chave primária da entidade
        gerente.merge(funcionario);

        // finalizar a transação com o banco
        gerente.getTransaction().commit();

        // fecho a conexão
        gerente.close();

    }

    public List<Cliente> listarPorNome(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Cliente> consulta
                = gerente.createNamedQuery("Cliente.findByClienteNome", Cliente.class);

        consulta.setParameter("cliNome", "%" + nomeProcurar + "%");

        return consulta.getResultList();
    }

    public List<Cliente> listarPorCPF(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Cliente> consulta
                = gerente.createNamedQuery("Cliente.findByClienteCPF", Cliente.class);

        consulta.setParameter("cliCPF", "%" + nomeProcurar + "%");

        return consulta.getResultList();
    }

    public void excluir(int codigo) throws IntegridadeException, NaoExisteException{

        // cria uma conexão com o banco
        
        EntityManager gerente = fabrica.gerente.criarGerente();

        boolean encontrado;
        // criando um identificador para um objeto usuário
        Cliente usuarioExcluir;

        // pego o usuário que possui o código passado do banco de
        // dadosusuarioExcluir = gerente.find(Cliente.class, codigo);
        usuarioExcluir = gerente.find(Cliente.class, codigo);

        // se o usuário não foi encontrado
        if (usuarioExcluir == null) {
            throw new NaoExisteException("ESTE Cliente nao existe");
        } else {
            
            try{
            // inicia uma transação
            gerente.getTransaction().begin();
            //excluir o usuário do banco de dados
            gerente.remove(usuarioExcluir);
            // finaliza a transação
            
            gerente.getTransaction().commit();
            // fechar a conexão
            gerente.close();
            }catch(Exception e ){
                throw new IntegridadeException("Não foi possível excluir o Cliente: "+ usuarioExcluir.getClienteNome()+" ");
            }
        }
    
    }

    public List<Cliente> CPFIgual(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Cliente> consulta
                = gerente.createNamedQuery("Cliente.findByClienteCPFIgual", Cliente.class);

        consulta.setParameter("cliCPF", nomeProcurar);

        return consulta.getResultList();
    }

    public List<Cliente> buscarEmail(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Cliente> consulta
                = gerente.createNamedQuery("Cliente.findByClienteEmailIgual", Cliente.class);

        consulta.setParameter("cliEmail", nomeProcurar);

        return consulta.getResultList();
    }

    
    
    public List<Cliente> buscarConta() {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Cliente> consulta
                = gerente.createNamedQuery("Cliente.listaClienteSemVendaAberta", Cliente.class);

       // consulta.setParameter("status", "A");

        return consulta.getResultList();
    }
    
    public List<Cliente> buscarContaNome(String nome) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Cliente> consulta
                = gerente.createNamedQuery("Cliente.listaClienteSemVendaAbertaNome", Cliente.class);

        consulta.setParameter("nome","%" + nome + "%");

        return consulta.getResultList();
    }
    
    
}
