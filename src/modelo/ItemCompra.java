/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Maycon
 */
@Entity
@Table(name = "itemcompra")
@NamedQueries({
    @NamedQuery(name = "ItemCompra.produtoVencimento",query= "SELECT ic  FROM ItemCompra ic where ic.notificar = 'n' and ic.dataVencimento BETWEEN :dataIni and :dataFim")
})
@IdClass(ItemCompraPK.class)
public class ItemCompra implements Serializable{
    
    
    @Id
    @ManyToOne
    @JoinColumn(name="compraCod", referencedColumnName = "compraCod")
    private CompraProduto compraCod;
    
    
    @Id
    @ManyToOne
    @JoinColumn(name="produtoCod", referencedColumnName = "produCod")
    private Produto produtoCod;
    

    @Column(name = "quantidade")
    private int quantidade;
    
    @Column(name = "valor")
    private double valor;
    
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    
    @Column(name = "notificado")
    private char notificar;

    public ItemCompra() {
    }

    public ItemCompra(CompraProduto compraCod, Produto produtoCod, int quantidade, double valor, Date dataVencimento, char notificar) {
        this.compraCod = compraCod;
        this.produtoCod = produtoCod;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.notificar = notificar;
    }

    public CompraProduto getCompraCod() {
        return compraCod;
    }

    public void setCompraCod(CompraProduto compraCod) {
        this.compraCod = compraCod;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public char getNotificar() {
        return notificar;
    }

    public void setNotificar(char notificar) {
        this.notificar = notificar;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.produtoCod);
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
        final ItemCompra other = (ItemCompra) obj;
        if (!Objects.equals(this.produtoCod, other.produtoCod)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemCompra{" + "compraCod=" + compraCod + ", produtoCod=" + produtoCod + ", quantidade=" + quantidade + ", valor=" + valor + ", dataVencimento=" + dataVencimento + ", notificar=" + notificar + '}';
    }

   

    
    
    

    
    
}
