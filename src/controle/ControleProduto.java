/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.Produto;
import modelo.Venda;

/**
 *
 * @author Maycon
 */
public class ControleProduto {

    public void gravarNovo(Produto Novo) {
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

    public List<Produto> listarTodos() {
        // lista de usuários a ser retornada
        List<Produto> listaUsuarios;

        // criar uma conexão com o banco - gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // Criar um identificar para uma consulta SQL
        TypedQuery<Produto> consultaUsuarios;

        // criar a consulta 
        consultaUsuarios = gerente.createNamedQuery("Produto.findAll", Produto.class);

        // pegar o resultado da consulta realizada
        listaUsuarios = consultaUsuarios.getResultList();

        return listaUsuarios;
    }

    public void salvarAlteracao(Produto funcionario) {
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

    public List<Produto> nomeIgual(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Produto> consulta
                = gerente.createNamedQuery("Produto.nomeIgual", Produto.class);

        consulta.setParameter("nomeProd", nomeProcurar);

        return consulta.getResultList();
    }

    public void excluir(int codigo) throws NaoExisteException, IntegridadeException{

        // cria uma conexão com o banco
        EntityManager gerente = fabrica.gerente.criarGerente();

        boolean encontrado;
        // criando um identificador para um objeto usuário
        Produto produto;

        // pego o usuário que possui o código passado do banco de
        // dados
        produto = gerente.find(Produto.class, codigo);

        // se o usuário não foi encontrado
        if (produto == null) {
            throw new NaoExisteException("Este Produto nao existe");
        } else {
            try{

            // inicia uma transação
            gerente.getTransaction().begin();

            //excluir o usuário do banco de dados
            gerente.remove(produto);

            // finaliza a transação
            gerente.getTransaction().commit();

            // fechar a conexão
            gerente.close();
            }catch(Exception e){
                throw new IntegridadeException("Não foi possível excluir o produto: "+ produto.getProdutoNome()+" ");
            }
        }
        
    }

    public List<Produto> listarPorNome(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Produto> consulta
                = gerente.createNamedQuery("Produto.findByProdutoNome", Produto.class);

        consulta.setParameter("prodNome", "%" + nomeProcurar + "%");

        return consulta.getResultList();
    }

    public List<Produto> listarPorNomeEstoque(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Produto> consulta
                = gerente.createNamedQuery("Produto.findByProdutoNomeEstoque", Produto.class);

        consulta.setParameter("prodNome", "%" + nomeProcurar + "%");

        return consulta.getResultList();
    }

    public List<Produto> listarTodosEstoque() {
        // lista de usuários a ser retornada
        List<Produto> listaUsuarios;

        // criar uma conexão com o banco - gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // Criar um identificar para uma consulta SQL
        TypedQuery<Produto> consultaUsuarios;

        // criar a consulta 
        consultaUsuarios = gerente.createNamedQuery("Produto.produtoQuantEstoque", Produto.class);

        // pegar o resultado da consulta realizada
        listaUsuarios = consultaUsuarios.getResultList();

        return listaUsuarios;
    }

    public Produto buscaCod(int x) {

        EntityManager gerente = fabrica.gerente.criarGerente();

        //boolean encontrado;
        // criando um identificador para um objeto usuário
        Produto p;

        // pego o usuário que possui o código passado do banco de
        // dados
        p = gerente.find(Produto.class, x);

        return p;
    }

    public void devolverProduto(Produto x, Venda v) {

        EntityManager gerente = fabrica.gerente.criarGerente();

        //boolean encontrado;
        // criando um identificador para um objeto usuário
        Produto p;

        // pego o usuário que possui o código passado do banco de
        // dados
        p = x;

        gerente.getTransaction().begin();
        p = gerente.find(Produto.class, x.getProdutoId());

        Venda vendaAt = gerente.find(Venda.class, v.getVendaCod());

        gerente.merge(v);

        p.setProdutoQuantidade(p.getProdutoQuantidade() + x.getProdutoQuantidade());
        gerente.merge(p);

        gerente.getTransaction().commit();

        // fecho a conexão
        gerente.close();

    }

    public List<Produto> produtoVencimento(Date dataIni, Calendar dataFim) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Produto> consulta = gerente.createNamedQuery("Produto.produtoVencimento", Produto.class);
        Date hoje = new Date();
        consulta.setParameter("dataIni", dataIni);
        consulta.setParameter("dataFim", dataFim);
        return consulta.getResultList();
    }

    public void gravarNovoETirarEstoque(Produto Novo, Produto produto) {
        // Identificador para objeto que gerencia uma entidade(acesso ao banco)
        EntityManager gerente = fabrica.gerente.criarGerente();

        // gravar o objeto cliente recebido como parâmetro no banco de dados
        // iniciar transação
        gerente.getTransaction().begin();

        produto.setProdutoQuantidade(produto.getProdutoQuantidade() - Novo.getProdutoQuantidade());
        gerente.merge(produto);
        // persistir o objeto no banco
        gerente.persist(Novo);

        // fazer um commit (salvar realmente no banco) na transação
        gerente.getTransaction().commit();

        // finalizar a conexão
        gerente.close();

    }
    
    
    
    public List<Produto> buscarNomeProdutoPromocao(String nomeProcurar) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Produto> consulta
                = gerente.createNamedQuery("Produto.nomeIgual", Produto.class);

        consulta.setParameter("nomeProd", nomeProcurar);

        return consulta.getResultList();
    }
    
    
    
    public void alterarPorNomePromocao(Produto nomeIgual, Produto produto, Produto prod) {

        EntityManager gerente = fabrica.gerente.criarGerente();
        Produto p;

        gerente.getTransaction().begin();
        p = gerente.find(Produto.class, prod.getProdutoId());

        p.setProdutoQuantidade(p.getProdutoQuantidade()-produto.getProdutoQuantidade());
        gerente.merge(p);

        
        nomeIgual.setProdutoQuantidade(nomeIgual.getProdutoQuantidade()+produto.getProdutoQuantidade());
        nomeIgual.setProdutoValorVenda(produto.getProdutoValorVenda());
        gerente.merge(nomeIgual);

        gerente.getTransaction().commit();


        gerente.close();

    }

}
