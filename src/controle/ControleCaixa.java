/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.Caixa;

/**
 *
 * @author Maycon
 */
public class ControleCaixa {
    
    
    private static Caixa caixaAberto = null;

    public static Caixa getCaixa() {
        return caixaAberto;
    }

    public static void setCaixa(Caixa caixaAberto) {
        ControleCaixa.caixaAberto = caixaAberto;
        //System.out.println(ControleCaixa.caixaAberto);
    }

    public static Caixa isCaixaAberto() {
        if (caixaAberto == null) {
            return null;
        } else {
            return caixaAberto;
        }
    }
    
    public static void caixaAberto()
    {
        ControleCaixa.caixaAberto = null;
    }
    
    
    
   
    
    
    
    
    public void gravarCaixa(Caixa x){
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
    
    
    
    
        public List<Caixa> buscar()    
    {
        // lista de usuários a ser retornada
        List<Caixa> listaUsuarios;
        
        // criar uma conexão com o banco - gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();
        
        // Criar um identificar para uma consulta SQL
        TypedQuery<Caixa> consultaUsuarios;
        
        // criar a consulta 
        consultaUsuarios = gerente.createNamedQuery("Caixa.buscaAberto", Caixa.class);
        
        // pegar o resultado da consulta realizada
        listaUsuarios = consultaUsuarios.getResultList();
        
        return listaUsuarios;
    }
        
        
        
        public void salvarAlteracao(Caixa caixa) {
        // criar um gerente de entidades
        EntityManager gerente = fabrica.gerente.criarGerente();

        // iniciar uma transação com o banco
        gerente.getTransaction().begin();

        //salvar a alteração no banco de dados
        // merge sobrepõe um registro no banco de dados com base na 
        //chave primária da entidade
        gerente.merge(caixa);

        // finalizar a transação com o banco
        gerente.getTransaction().commit();

        // fecho a conexão
        gerente.close();

    }
}
