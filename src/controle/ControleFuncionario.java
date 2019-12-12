/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Funcionario;

/**
 *
 * @author Maycon
 */
public class ControleFuncionario {

    private static Funcionario usuarioLogado = null;

    public static Funcionario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Funcionario usuarioLogado) {
        ControleFuncionario.usuarioLogado = usuarioLogado;
    }

    public static Funcionario isFuncionarioLogado() {
        if (usuarioLogado == null) {
            return null;
        } else {
            return usuarioLogado;
        }
    }

    public static void logoutUsuario() {
        ControleFuncionario.usuarioLogado = null;
    }

    public static boolean logarUsuario(String email, String senha) {

        boolean logou = false;

        EntityManager gerente = fabrica.gerente.criarGerente();

        List<Funcionario> listaUsuarios;

        // cria uma consulta com base na NamedQuery "Usuario.Acessar" que pesquisa
        // por nome de usuário e senha.
        TypedQuery<Funcionario> consultaUsuario
                = gerente.createNamedQuery("Funcionario.Acessar", Funcionario.class);

        consultaUsuario.setParameter("email", email);
        consultaUsuario.setParameter("senha", senha);

        listaUsuarios = consultaUsuario.getResultList();

        // verifica se na lista de retorno tem algum usuário
        if (listaUsuarios.isEmpty()) {
            // se ela estiver vazia, não há usuário logado
            ControleFuncionario.usuarioLogado = null;

        } else {
            // se houver usuário na lista indicar o primeiro usuário como 
            // sendo o usuário logado

            //ControleFuncionario.usuarioLogado = listaUsuarios.get(0);
            logou = true;
        }

        return logou;
    }

    public void gravarNovo(Funcionario Novo) {
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

    public List<Funcionario> listarTodos() {
        // lista de usuários a ser retornada
        List<Funcionario> listaUsuarios;

        // criar uma conexão com o banco - gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // Criar um identificar para uma consulta SQL
        TypedQuery<Funcionario> consultaUsuarios;

        // criar a consulta 
        consultaUsuarios = gerente.createNamedQuery("Funcionario.findAll", Funcionario.class);

        // pegar o resultado da consulta realizada
        listaUsuarios = consultaUsuarios.getResultList();

        return listaUsuarios;
    }

    public void salvarAlteracao(Funcionario funcionario) {
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

    public List<Funcionario> listarPorNome(String nomeProcurar, int x) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Funcionario> consulta
                = gerente.createNamedQuery("Funcionario.findByFuncionarioNome", Funcionario.class);

        consulta.setParameter("funNome", "%" + nomeProcurar + "%");

        consulta.setParameter("funcionarioId", x);

        return consulta.getResultList();
    }

    public List<Funcionario> listarPorCPF(String nomeProcurar, int x) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Funcionario> consulta
                = gerente.createNamedQuery("Funcionario.findByFuncionarioCPF", Funcionario.class);

        consulta.setParameter("funCPF", "%" + nomeProcurar + "%");
        consulta.setParameter("funcionarioId", x);

        return consulta.getResultList();
    }

    public void excluir(int codigo) throws NaoExisteException, IntegridadeException{

        // cria uma conexão com o banco
        EntityManager gerente = fabrica.gerente.criarGerente();

        // criando um identificador para um objeto usuário
        Funcionario f;

        // pego o usuário que possui o código passado do banco de
        // dados
        f = gerente.find(Funcionario.class, codigo);

        // se o usuário não foi encontrado
        if (f == null) {

        } else {

            try {
                // inicia uma transação
                gerente.getTransaction().begin();

                //excluir o usuário do banco de dados
                gerente.remove(f);

                // finaliza a transação
                gerente.getTransaction().commit();

                // fechar a conexão
                gerente.close();
            }catch(Exception e){
                throw new IntegridadeException("Não foi possível excluir o funcionario: "+ f.getFuncionarioNome()+" ");
            }
            
        }

        
    }

    public List<Funcionario> buscarEmail(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Funcionario> consulta
                = gerente.createNamedQuery("Funcionario.findByFuncionarioEmailIgual", Funcionario.class);

        consulta.setParameter("funcionarioEmail", nomeProcurar);

        return consulta.getResultList();
    }

    public List<Funcionario> CPFIgual(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Funcionario> consulta
                = gerente.createNamedQuery("Funcionario.findByFuncionarioCPFIgual", Funcionario.class);

        consulta.setParameter("funCPF", nomeProcurar);

        return consulta.getResultList();
    }

    public Funcionario findAcha(String email, String senha) {
        EntityManager em = fabrica.gerente.criarGerente();
        Query query = em.createNamedQuery("Funcionario.achar", Funcionario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        if (query.getResultList().isEmpty()) {
            return null;
        }
        return (Funcionario) query.getSingleResult();
    }

    public Funcionario buscaEu(int func) {
        EntityManager em = fabrica.gerente.criarGerente();
        Query query = em.createNamedQuery("Funcionario.findByFuncionarioId", Funcionario.class);
        query.setParameter("funcionario", func);
        if (query.getResultList().isEmpty()) {
            return null;
        }
        return (Funcionario) query.getSingleResult();
    }

    public long conta() {
        EntityManager em = fabrica.gerente.criarGerente();
        Query query = em.createNamedQuery("Funcionario.conta", Funcionario.class);
        long conta = (long) query.getSingleResult();
        return conta;
    }

    public List<Funcionario> semUsuario(int x) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Funcionario> consulta
                = gerente.createNamedQuery("Funcionario.semUsuario", Funcionario.class);

        consulta.setParameter("funcionarioId", x);

        return consulta.getResultList();
    }
}
