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
@Table(name = "venda")
@NamedQueries({
    @NamedQuery(name = "Venda.listaVendaAberta",
            query = "SELECT v FROM Venda v where v.status like :descricao order by v.vendaCod ")
    ,
    @NamedQuery(name = "Venda.listaVendaPendente",
            query = "SELECT v FROM Venda v where v.status ='P' order by v.vendaCod ")
    ,
    @NamedQuery(name = "Venda.listaVendaPendenteConta",
            query = "SELECT v FROM Venda v where v.status ='P' ORDER BY v.clienteCod"), //    @NamedQuery(name = "Venda.listaClienteSemVendaAberta", query = "SELECT c FROM Cliente c WHERE c.clienteId  NOT IN (SELECT v.clienteCod.clienteId  FROM Venda v )")
//   @NamedQuery(name = "Venda.listaClienteSemVendaAberta", query = "SELECT v FROM Venda v WHERE v.clienteCod.clienteId NOT IN (SELECT c.clienteId  FROM Cliente c )")
})
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendaCod")
    private int vendaCod;
    @Column(name = "vendaData")
    @Temporal(TemporalType.DATE)
    private Date vendaData;
    @Column(name = "vendaHora")
    @Temporal(TemporalType.TIME)
    private Date vendaHora;
    @Column(name = "vendaTotal")
    private double vendaTotal;
    @Column(name = "nrNota")
    private int nrNota;
    @Column(name = "status", length = 1)
    private char status;

    @ManyToOne
    @JoinColumn(name = "clienteCod", referencedColumnName = "clienteCod")
    private Cliente clienteCod;

    @OneToMany(mappedBy = "vendaCod", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ItemVenda> listaVenda;

    @OneToMany(mappedBy = "vendaCod", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Recebimento> listaRecebimento;

    public Venda() {

    }

    public Venda(int vendaCod, Date vendaData, Date vendaHora, double vendaTotal, int nrNota, char status, Cliente clienteCod) {
        this.vendaCod = vendaCod;
        this.vendaData = vendaData;
        this.vendaHora = vendaHora;
        this.vendaTotal = vendaTotal;
        this.nrNota = nrNota;
        this.status = status;
        this.clienteCod = clienteCod;
    }

    public int getVendaCod() {
        return vendaCod;
    }

    public void setVendaCod(int vendaCod) {
        this.vendaCod = vendaCod;
    }

    public Date getVendaData() {
        return vendaData;
    }

    public void setVendaData(Date vendaData) {
        this.vendaData = vendaData;
    }

    public Date getVendaHora() {
        return vendaHora;
    }

    public void setVendaHora(Date vendaHora) {
        this.vendaHora = vendaHora;
    }

    public double getVendaTotal() {
        return vendaTotal;
    }

    public void setVendaTotal(double vendaTotal) {
        this.vendaTotal = vendaTotal;
    }

    public int getNrNota() {
        return nrNota;
    }

    public void setNrNota(int nrNota) {
        this.nrNota = nrNota;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Cliente getClienteCod() {
        return clienteCod;
    }

    public void setClienteCod(Cliente clienteCod) {
        this.clienteCod = clienteCod;
    }

    public List<ItemVenda> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(List<ItemVenda> listaVenda) {
        this.listaVenda = listaVenda;
        for (ItemVenda iv : listaVenda) {
            iv.setVendaCod(this);
        }
    }

    public List<Recebimento> getListaRecebimento() {
        return listaRecebimento;
    }

    public void setListaRecebimento(List<Recebimento> listaRecebimento) {
        this.listaRecebimento = listaRecebimento;
        for (Recebimento iv : listaRecebimento) {
            iv.setVendaCod(this);
        }
    }

    public double getTotalRecebido() {
        double total = 0;
        if (!listaRecebimento.isEmpty()) {
            for (Recebimento r : listaRecebimento) {

                total += r.getValorRecebido();

            }
        } else {
            return total;
        }
        return total;
    }

    public double getTotalVenda() {
        double total = 0;
        for (ItemVenda iv : listaVenda) {
            total += iv.getValor();
        }
        return total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.vendaCod;
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
        final Venda other = (Venda) obj;
        if (this.vendaCod != other.vendaCod) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String retorno = "NOVA VENDA";
        if (clienteCod != null) {

            retorno = clienteCod.getClienteNome();
        }
        return retorno;
    }

}
