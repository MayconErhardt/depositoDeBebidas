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

import modelo.CompraProduto;
import modelo.ItemCompra;
import modelo.Produto;

/**
 *
 * @author Maycon
 */
public class ControleCompraProduto {
    
    public void gravarNovo(CompraProduto novo)
    {
     // Identificador para objeto que gerencia uma entidade(acesso ao banco)
        EntityManager gerente = fabrica.gerente.criarGerente();
        // iniciar transação
        gerente.getTransaction().begin();
        
        // persistir o objeto no banco
        gerente.persist(novo);
        
        for(ItemCompra ic : novo.getListaCompra())
        {
            Produto x = ic.getProdutoCod();
            x.setProdutoQuantidade(x.getProdutoQuantidade()+ic.getQuantidade());
            x.setProdutoValorCompra(ic.getValor());
            gerente.merge(x);
        }        
        
        // fazer um commit (salvar realmente no banco) na transação
        gerente.getTransaction().commit();
        
        // finalizar a conexão
        gerente.close();
        
    }
    
    public List<CompraProduto> listarTodos() {
        // lista de usuários a ser retornada
        List<CompraProduto> listaUsuarios;

        // criar uma conexão com o banco - gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // Criar um identificar para uma consulta SQL
        TypedQuery<CompraProduto> consultaUsuarios;

        // criar a consulta 
        consultaUsuarios = gerente.createNamedQuery("CompraProduto.findAll", CompraProduto.class);

        // pegar o resultado da consulta realizada
        listaUsuarios = consultaUsuarios.getResultList();

        return listaUsuarios;
    }
    
    
    public List<CompraProduto> listarCompraFornecedor(String x) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<CompraProduto> consulta
                = gerente.createNamedQuery("CompraProduto.porFornecedor", CompraProduto.class);

        consulta.setParameter("nome", "%" + x + "%");

        return consulta.getResultList();
    }
    
    
    public List<CompraProduto> listarPorPeriodoFornecedor(Date dataIni,Date dataFim) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<CompraProduto> consulta = gerente.createNamedQuery("CompraProduto.porFornecedorPeriodo", CompraProduto.class);

        consulta.setParameter("dataIni", dataIni);
        consulta.setParameter("dataFim", dataFim);
        //JOptionPane.showMessageDialog(null, consulta);
        return consulta.getResultList();
    }
    
    
    
}
