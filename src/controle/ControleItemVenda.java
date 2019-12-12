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

/**
 *
 * @author Maycon
 */
public class ControleItemVenda {
    
    public boolean excluirItemVenda(int prod, int venda) {

        // cria uma conexão com o banco
        EntityManager gerente = fabrica.gerente.criarGerente();

        boolean encontrado;
        // criando um identificador para um objeto usuário
        ItemVenda usuarioExcluir;

        // pego o usuário que possui o código passado do banco de
        // dadosusuarioExcluir = gerente.find(Cliente.class, codigo);
        usuarioExcluir = gerente.find(ItemVenda.class, prod);
        usuarioExcluir = gerente.find(ItemVenda.class, venda);

        // se o usuário não foi encontrado
        if (usuarioExcluir == null) {
            encontrado = false;
        } else {
            encontrado = true;

            // inicia uma transação
            gerente.getTransaction().begin();

            //excluir o usuário do banco de dados
            gerente.remove(usuarioExcluir);

            // finaliza a transação
            gerente.getTransaction().commit();

            // fechar a conexão
            gerente.close();

        }
        return encontrado;
    }

    
    public List<ItemVenda> VendaPeriodo(Date inicio,Date fim){
        EntityManager gerente = fabrica.gerente.criarGerente();
        TypedQuery<ItemVenda> consulta = gerente.createNamedQuery("ItemVenda.periodoVenda", ItemVenda.class);        
        consulta.setParameter("dataInicio", inicio);
        consulta.setParameter("dataFim", fim);        
        return consulta.getResultList();
    }
    
    
}
