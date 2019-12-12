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
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;
import modelo.Caixa;

import modelo.Recebimento;
import modelo.Venda;
import view.Fundamental.RealizarVenda.Receber;

/**
 *
 * @author Maycon
 */
public class ControleRecebimento {

    public void receber(Recebimento Novo) {
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

//    public Recebimento buscaContaRecebida(int codVenda) {
//        EntityManager em = fabrica.gerente.criarGerente();
//        TypedQuery<Recebimento> consulta = em.createNamedQuery("Receber.buscarContaRecebida", Recebimento.class);
//        consulta.setParameter("vCod", +codVenda);
//        Recebimento res = (Recebimento) consulta.getSingleResult();
//        return res;
//    }

    public double buscaConta(int codVenda) {

        EntityManager gerente = fabrica.gerente.criarGerente();
        Double x=0.0;
        Query query = gerente.createNamedQuery("Receber.buscarContaRecebida", Recebimento.class);

        query.setParameter("codValor", codVenda);
     ///   JOptionPane.showMessageDialog(null, "oii");
        
        x = (Double) query.getSingleResult();
        if(x==null){
            return 0;
        }
        
        return x;
    }
    
    
    public List<Recebimento> buscarRecebimentoCaixa(Caixa x){
        EntityManager gerente = fabrica.gerente.criarGerente();

        TypedQuery<Recebimento> consulta
                = gerente.createNamedQuery("Recebimento.findByBuscaCaixaRecebimento", Recebimento.class);

        consulta.setParameter("codCaixa", x.getCaixaCod() );

        return consulta.getResultList();
    }
}
