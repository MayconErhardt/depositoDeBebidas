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
import modelo.ItemCompra;
import modelo.ItemVenda;

/**
 *
 * @author Maycon
 */
public class ControleItemCompra {
    public void gravarNovo(ItemCompra Novo)
    {
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
    
    
    public List<ItemCompra> produtoVencimento(Date dataIni,Date dataFim) {
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<ItemCompra> consulta = gerente.createNamedQuery("ItemCompra.produtoVencimento", ItemCompra.class);
        Date hoje = new Date();
        consulta.setParameter("dataIni", dataIni);
        consulta.setParameter("dataFim", dataFim);        
        return consulta.getResultList();
    }
    
    
    public void salvarAlteracao(ItemCompra ic) {
        // criar um gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        gerente.getTransaction().begin();

        //salvar a alteração no banco de dados
        // merge sobrepõe um registro no banco de dados com base na 
        //chave primária da entidade
        gerente.merge(ic);

        // finalizar a transação com o banco
        gerente.getTransaction().commit();

        // fecho a conexão
        gerente.close();

    }
    
     
    
    
}
