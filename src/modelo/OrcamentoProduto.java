/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Maycon
 */

@Entity
@Table(name = "orcamentoproduto")
@IdClass(OrcamentoProdutoPK.class)
public class OrcamentoProduto implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name="orcamentoCod", referencedColumnName = "orcCod")
    private Orcamento orcCod;
    
    @Id
    @ManyToOne
    @JoinColumn(name="produtoCod", referencedColumnName = "produCod")
    private Produto produtoCod;
    
    
    @Column(name = "quantidade")
    private int quantidade;
    
    @Column(name = "quantDevolvida")
    private int quantidadeDevolvida;
    
    @Column(name = "valor")
    private double valor;

    public OrcamentoProduto() {
    }

    public OrcamentoProduto(Orcamento orcCod, Produto produtoCod, int quantidade, int quantidadeDevolvida, double valor) {
        this.orcCod = orcCod;
        this.produtoCod = produtoCod;
        this.quantidade = quantidade;
        this.quantidadeDevolvida = quantidadeDevolvida;
        this.valor = valor;
    }

    public Orcamento getOrcCod() {
        return orcCod;
    }

    public void setOrcCod(Orcamento orcCod) {
        this.orcCod = orcCod;
    }

    public Produto getProdutoCod() {
        return produtoCod;
    }

    public void setProdutoCod(Produto produtoCod) {
        this.produtoCod = produtoCod;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeDevolvida() {
        return quantidadeDevolvida;
    }

    public void setQuantidadeDevolvida(int quantidadeDevolvida) {
        this.quantidadeDevolvida = quantidadeDevolvida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "OrcamentoProduto{" + "orcCod=" + orcCod + ", produtoCod=" + produtoCod + ", quantidade=" + quantidade + '}';
    }
    
    
    
    
    
}
