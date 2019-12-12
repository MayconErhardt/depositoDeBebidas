/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.ItemVenda;
import modelo.Produto;
import modelo.Venda;

/**
 *
 * @author Maycon
 */
public class ControleVenda {

    private static int nrNota = 1;

    public static int getNrNota() {
        return nrNota;
    }

    public static void setNrNota(int nrNota) {
        ControleVenda.nrNota = nrNota;
    }

    public static int isNrNota() {

        return nrNota;

    }

    public void gravarNovo(Venda novo) {
        // Identificador para objeto que gerencia uma entidade(acesso ao banco)
        EntityManager gerente = fabrica.gerente.criarGerente();
        // iniciar transação
        gerente.getTransaction().begin();

        // persistir o objeto no banco
        gerente.persist(novo);

        for (ItemVenda iv : novo.getListaVenda()) {
            Produto x = iv.getProdutoCod();
            x.setProdutoQuantidade(x.getProdutoQuantidade() - iv.getQuantidade());
            x.setProdutoValorCompra(iv.getValor());
            gerente.merge(x);
        }

        // fazer um commit (salvar realmente no banco) na transação
        gerente.getTransaction().commit();

        // finalizar a conexão
        gerente.close();

    }

    public List<Venda> listaVendaAberta() {
        // lista de usuários a ser retornada
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Venda> consulta
                = gerente.createNamedQuery("Venda.listaVendaAberta", Venda.class);

        consulta.setParameter("descricao", 'A');

        return consulta.getResultList();

    }

    public List<Venda> listarVendaPendente() {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Venda> consulta
                = gerente.createNamedQuery("Venda.listaVendaPendente", Venda.class);

        return consulta.getResultList();
    }

    public void salvarAlteracao(Venda v) {
        // criar um gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // iniciar uma transação com o banco
        gerente.getTransaction().begin();

        Venda vendaAntiga = gerente.find(Venda.class, v.getVendaCod());
        for (ItemVenda iv : vendaAntiga.getListaVenda()) {
            Produto x = iv.getProdutoCod();
            x.setProdutoQuantidade(x.getProdutoQuantidade() + iv.getQuantidade());
            gerente.merge(x);
        }

        for (ItemVenda iv : v.getListaVenda()) {
            Produto x = gerente.find(Produto.class, iv.getProdutoCod().getProdutoId());
            x.setProdutoQuantidade(x.getProdutoQuantidade() - iv.getQuantidade());
            gerente.merge(x);
        }

        gerente.merge(v);
        // finalizar a transação com o banco
        gerente.getTransaction().commit();

        // fecho a conexão
        gerente.close();

    }

    public void devolver(Venda v) {
        // criar um gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // iniciar uma transação com o banco
        gerente.getTransaction().begin();

        Venda vendaAntiga = gerente.find(Venda.class, v.getVendaCod());
        for (ItemVenda iv : vendaAntiga.getListaVenda()) {
            Produto x = iv.getProdutoCod();
            x.setProdutoQuantidade(x.getProdutoQuantidade() - iv.getQuantidade());

            gerente.merge(x);
        }
        gerente.merge(v);

        for (ItemVenda iv : v.getListaVenda()) {
            Produto x = iv.getProdutoCod();
            x.setProdutoQuantidade(x.getProdutoQuantidade() + iv.getQuantidade());
            gerente.merge(x);
        }

        // finalizar a transação com o banco
        gerente.getTransaction().commit();

        // fecho a conexão
        gerente.close();

    }

    public List<Venda> contaPendenteRelatorio() {

        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Venda> consulta
                = gerente.createNamedQuery("Venda.listaVendaPendenteConta", Venda.class);

        return consulta.getResultList();
    }

}
