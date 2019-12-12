/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Maycon
 */
@Entity
@Table(name = "itemVenda")
@NamedQueries({
   
        @NamedQuery(name = "ItemVenda.periodoVenda", 
            query = "SELECT v FROM ItemVenda v where v.vendaCod.vendaData BETWEEN :dataInicio and :dataFim order by v.produtoCod.produtoNome"),
    
//    @NamedQuery(name = "Venda.listaClienteSemVendaAberta", query = "SELECT c FROM Cliente c WHERE c.clienteId  NOT IN (SELECT v.clienteCod.clienteId  FROM Venda v )")
 //   @NamedQuery(name = "Venda.listaClienteSemVendaAberta", query = "SELECT v FROM Venda v WHERE v.clienteCod.clienteId NOT IN (SELECT c.clienteId  FROM Cliente c )")
})

@IdClass(ItemVendaPK.class)
public class ItemVenda implements Serializable {

    @Id
    @Column(name = "nrItem")
    private int nrItem;

    @Id
    @ManyToOne
    @JoinColumn(name = "vendaCod", referencedColumnName = "vendaCod")
    private Venda vendaCod;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "valor")
    private double valor;

    @ManyToOne
    @JoinColumn(name = "produtoCod", referencedColumnName = "produCod")
    private Produto produtoCod;

    public ItemVenda() {
    }

    public ItemVenda(int nrItem, Venda vendaCod, int quantidade, double valor, Produto produtoCod) {
        this.nrItem = nrItem;
        this.vendaCod = vendaCod;
        this.quantidade = quantidade;
        this.valor = valor;
        this.produtoCod = produtoCod;
    }

    public int getNrItem() {
        return nrItem;
    }

    public void setNrItem(int nrItem) {
        this.nrItem = nrItem;
    }

    public Venda getVendaCod() {
        return vendaCod;
    }

    public void setVendaCod(Venda vendaCod) {
        this.vendaCod = vendaCod;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Produto getProdutoCod() {
        return produtoCod;
    }

    public void setProdutoCod(Produto produtoCod) {
        this.produtoCod = produtoCod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.nrItem;
        hash = 71 * hash + Objects.hashCode(this.vendaCod);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemVenda other = (ItemVenda) obj;
        if (this.nrItem != other.nrItem) {
            return false;
        }
        if (!Objects.equals(this.vendaCod, other.vendaCod)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "nrItem=" + nrItem + ", vendaCod=" + vendaCod + ", quantidade=" + quantidade + ", valor=" + valor + ", produtoCod=" + produtoCod + '}';
    }

}
