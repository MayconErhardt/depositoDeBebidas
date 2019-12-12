/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.ItemVenda;
import modelo.Orcamento;
import modelo.OrcamentoProduto;
import modelo.Produto;
import modelo.Venda;

/**
 *
 * @author Maycon
 */
public class ControleOrcamento {

    public void gravarOrcamento(Orcamento x) {
        // Identificador para objeto que gerencia uma entidade(acesso ao banco)
        EntityManager gerente = fabrica.gerente.criarGerente();

        // gravar o objeto cliente recebido como parâmetro no banco de dados
        // iniciar transação
        gerente.getTransaction().begin();

        // persistir o objeto no banco
        gerente.persist(x);

        // fazer um commit (salvar realmente no banco) na transação
        gerente.getTransaction().commit();

        // finalizar a conexão
        gerente.close();
    }

    public void salvarAlteracao(Orcamento orcamentoAlterar) {
        // criar um gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // iniciar uma transação com o banco
        gerente.getTransaction().begin();

        //salvar a alteração no banco de dados
        // merge sobrepõe um registro no banco de dados com base na 
        //chave primária da entidade
        gerente.merge(orcamentoAlterar);

        // finalizar a transação com o banco
        gerente.getTransaction().commit();

        // fecho a conexão
        gerente.close();

    }

    public List<Orcamento> listarTodosAberto() {
        // lista de usuários a ser retornada
        List<Orcamento> listaOrcamento;

        // criar uma conexão com o banco - gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // Criar um identificar para uma consulta SQL
        TypedQuery<Orcamento> consultaOrcamento;

        // criar a consulta 
        consultaOrcamento = gerente.createNamedQuery("Orcamento.orcamentoAberto", Orcamento.class);

        // pegar o resultado da consulta realizada
        listaOrcamento = consultaOrcamento.getResultList();

        return listaOrcamento;
    }

    public List<Orcamento> listarOrcamentoAbertoPorNomeCliente(String x) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Orcamento> consulta
                = gerente.createNamedQuery("Orcamento.orcamentoAbertoNomeCliente", Orcamento.class);

        consulta.setParameter("nome", "%" + x + "%");

        return consulta.getResultList();
    }

    public List<Orcamento> listarTodosAprovado() {
        // lista de usuários a ser retornada
        List<Orcamento> listaOrcamento;

        // criar uma conexão com o banco - gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // Criar um identificar para uma consulta SQL
        TypedQuery<Orcamento> consultaOrcamento;

        // criar a consulta 
        consultaOrcamento = gerente.createNamedQuery("Orcamento.orcamentoAprovado", Orcamento.class);

        // pegar o resultado da consulta realizada
        listaOrcamento = consultaOrcamento.getResultList();

        return listaOrcamento;
    }

    public List<Orcamento> listarOrcamentoAprovadoPorNomeCliente(String x) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Orcamento> consulta
                = gerente.createNamedQuery("Orcamento.orcamentoAprovadoNomeCliente", Orcamento.class);

        consulta.setParameter("nome", "%" + x + "%");

        return consulta.getResultList();
    }

    public void gravarBaixaEstoque(Orcamento baixa) {
        // Identificador para objeto que gerencia uma entidade(acesso ao banco)
        EntityManager gerente = fabrica.gerente.criarGerente();
        // iniciar transação
        gerente.getTransaction().begin();

        for (OrcamentoProduto o : baixa.getListaOrcamento()) {
            Produto x = o.getProdutoCod();
            x.setProdutoQuantidade(x.getProdutoQuantidade() - o.getQuantidade());
            gerente.merge(x);
        }
        gerente.merge(baixa);

        gerente.getTransaction().commit();

        gerente.close();

    }

    public List<Orcamento> listarTodosEntregue() {
        // lista de usuários a ser retornada
        List<Orcamento> listaOrcamento;

        // criar uma conexão com o banco - gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // Criar um identificar para uma consulta SQL
        TypedQuery<Orcamento> consultaOrcamento;

        // criar a consulta 
        consultaOrcamento = gerente.createNamedQuery("Orcamento.orcamentoEntregue", Orcamento.class);

        // pegar o resultado da consulta realizada
        listaOrcamento = consultaOrcamento.getResultList();

        return listaOrcamento;
    }

    public List<Orcamento> listarOrcamentoEntreguePorNomeCliente(String x) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Orcamento> consulta
                = gerente.createNamedQuery("Orcamento.orcamentoEntregueNomeCliente", Orcamento.class);

        consulta.setParameter("nome", "%" + x + "%");

        return consulta.getResultList();
    }

    public void atualizarEstoque(Orcamento orcamento) {

        EntityManager gerente = fabrica.gerente.criarGerente();

        // iniciar uma transação com o banco
        gerente.getTransaction().begin();

        for (OrcamentoProduto op : orcamento.getListaOrcamento()) {

            Produto x = op.getProdutoCod();

            x.setProdutoQuantidade(x.getProdutoQuantidade() + op.getQuantidadeDevolvida());

            gerente.merge(x);
        }

        // finalizar a transação com o banco
        gerente.getTransaction().commit();

        // fecho a conexão
        gerente.close();

    }

    public void finalizarConsignacao(Orcamento orcamento) {

        EntityManager gerente = fabrica.gerente.criarGerente();

        Venda v = new Venda();

        v.setClienteCod(orcamento.getClienteCod());

        v.setNrNota(ControleVenda.isNrNota());

        v.setStatus('P');

        v.setVendaData(orcamento.getDataDevolucao());

        v.setVendaHora(orcamento.getDataDevolucao());

        v.setListaVenda(new ArrayList<>());

        double valorVendaOrcamento = 0;
        int i = 0;
        for (OrcamentoProduto orcProdu : orcamento.getListaOrcamento()) {
            ItemVenda iv = new ItemVenda();
            iv.setNrItem(++i);
            iv.setProdutoCod(orcProdu.getProdutoCod());
            iv.setValor(orcProdu.getValor());
            iv.setQuantidade(orcProdu.getQuantidade() - orcProdu.getQuantidadeDevolvida());
            iv.setVendaCod(v);
            valorVendaOrcamento += iv.getValor() * iv.getQuantidade();
            v.getListaVenda().add(iv);
        }
        if (valorVendaOrcamento > 0) {
            v.setVendaTotal(valorVendaOrcamento);
        } else {
            v.setListaVenda(new ArrayList<>());
            v.setVendaTotal(100);
        }
        // iniciar uma transação com o banco
        gerente.getTransaction().begin();

        // persistir a venda no banco
        gerente.persist(v);

        for (OrcamentoProduto op : orcamento.getListaOrcamento()) {

            Produto x = op.getProdutoCod();

            x.setProdutoQuantidade(x.getProdutoQuantidade() + op.getQuantidadeDevolvida());

            gerente.merge(x);
        }

        gerente.merge(orcamento);
        gerente.getTransaction().commit();
        gerente.close();

    }

    public double getValorAtualizado(Orcamento o) {

        double valor = 0;
        for (OrcamentoProduto ic : o.getListaOrcamento()) {
            Produto x = ic.getProdutoCod();
            valor += x.getProdutoValorVenda();
        }
        return valor;
    }

    public List<OrcamentoProduto> atualizarListaOrcamento(Orcamento o) {
        ArrayList<OrcamentoProduto> listOrcamento = new ArrayList<>();

        for (OrcamentoProduto ic : o.getListaOrcamento()) {
            Produto x = ic.getProdutoCod();
            ic.setValor(x.getProdutoValorVenda());
            listOrcamento.add(ic);
        }
        return listOrcamento;
    }

    public boolean verficarOrcamento(Orcamento o) {

        boolean falta = false;
        for (OrcamentoProduto op : o.getListaOrcamento()) {
            if(op.getQuantidade()>op.getProdutoCod().getProdutoQuantidade()){
                return true;
            }
        }
        return false;
    }

}
