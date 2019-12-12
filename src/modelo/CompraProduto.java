/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Maycon
 */
@Entity
@Table(name = "compraProduto")

@NamedQueries({
    @NamedQuery(name = "CompraProduto.findAll", query = "SELECT cp FROM CompraProduto cp GROUP BY cp.compraCod")
    ,
    @NamedQuery(name = "CompraProduto.porFornecedorPeriodo", query = "SELECT cp FROM CompraProduto cp WHERE cp.dataCompra  between :dataIni and :dataFim")
    ,
        @NamedQuery(name = "CompraProduto.porFornecedor", query = "SELECT cp FROM CompraProduto cp WHERE cp.fornecedorCod.fornecedorRazaoSicial like :nome")
})
public class CompraProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compraCod")
    private int compraCod;

    @Column(name = "quantParcela")
    private int quantParcela;

    @Column(name = "valorTotal")
    private double valorTotal;

    @Column(name = "dataCompra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;

    @Column(name = "notaFiscalFornecedor")
    private int notaFiscalFornecedor;

    @ManyToOne
    @JoinColumn(name = "fornecedorCod", referencedColumnName = "fornecedorCod")
    private Fornecedor fornecedorCod;

    @OneToMany(mappedBy = "compraCod", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ItemCompra> listaCompra;

    @OneToMany(mappedBy = "compraProduto", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Pagamento> listaParcela;

    public CompraProduto() {
    }

    public CompraProduto(int compraCod, int quantParcela, double valorTotal, Date dataCompra, int notaFiscalFornecedor, Fornecedor fornecedorCod) {
        this.compraCod = compraCod;
        this.quantParcela = quantParcela;
        this.valorTotal = valorTotal;
        this.dataCompra = dataCompra;
        this.notaFiscalFornecedor = notaFiscalFornecedor;
        this.fornecedorCod = fornecedorCod;

    }

    public int getCompraCod() {
        return compraCod;
    }

    public void setCompraCod(int compraCod) {
        this.compraCod = compraCod;
    }

    public int getQuantParcela() {
        return quantParcela;
    }

    public void setQuantParcela(int quantParcela) {
        this.quantParcela = quantParcela;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getNotaFiscalFornecedor() {
        return notaFiscalFornecedor;
    }

    public void setNotaFiscalFornecedor(int notaFiscalFornecedor) {
        this.notaFiscalFornecedor = notaFiscalFornecedor;
    }

    public Fornecedor getFornecedorCod() {
        return fornecedorCod;
    }

    public void setFornecedorCod(Fornecedor fornecedorCod) {
        this.fornecedorCod = fornecedorCod;
    }

    public List<ItemCompra> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<ItemCompra> listaCompra) {
        this.listaCompra = listaCompra;
        for (ItemCompra ic : this.getListaCompra()) {
            ic.setCompraCod(this);
            // pag.seDescricao("Parcela nr." + pag.nrmero+" da nf nr. " +this.notaFiscalFornecedor + "do fornecedor"+ this.fornecedorCod.getFornecedorRazaoSicial())
            ;
        }
    }

    public List<Pagamento> getListaParcela() {
        return listaParcela;
    }

    public void setListaParcela(List<Pagamento> listaParcela) {
        this.listaParcela = listaParcela;
        for (Pagamento ic : this.getListaParcela()) {
            ic.setCompraProduto(this);
            ic.setDescricao("Parcela nr." + ic.getNumeroParcela() + " do fornecedor " + ic.getCompraProduto().getFornecedorCod().getFornecedorRazaoSicial());
        }
    }

    @Override
    public String toString() {
        return "CompraProduto{" + "compraCod=" + compraCod + ", quantParcela=" + quantParcela + ", valorTotal=" + valorTotal + ", dataCompra=" + dataCompra + ", notaFiscalFornecedor=" + notaFiscalFornecedor + ", fornecedorCod=" + fornecedorCod + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.compraCod;
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
        final CompraProduto other = (CompraProduto) obj;
        if (this.compraCod != other.compraCod) {
            return false;
        }
        return true;
    }

    public void setCompraCod(CompraProduto compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
