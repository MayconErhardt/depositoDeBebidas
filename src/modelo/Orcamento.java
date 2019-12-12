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
@Table(name = "orcamento")

@NamedQueries({
    @NamedQuery(name = "Orcamento.orcamentoAberto", query = "SELECT o FROM Orcamento o where o.dataAprovacao IS NULL  ORDER BY o.clienteCod.clienteNome")
    ,
    @NamedQuery(name = "Orcamento.orcamentoAbertoNomeCliente", query = "SELECT o FROM Orcamento o where o.clienteCod.clienteNome like :nome AND o.dataAprovacao IS NULL ORDER BY o.clienteCod.clienteNome")
    ,
    @NamedQuery(name = "Orcamento.orcamentoAprovado", query = "SELECT o FROM Orcamento o where o.dataAprovacao IS NOT NULL AND o.dataEntrega IS NULL ORDER BY o.clienteCod.clienteNome")
    ,
    @NamedQuery(name = "Orcamento.orcamentoEntregue", query = "SELECT o FROM Orcamento o where o.dataAprovacao IS NOT NULL AND o.dataEntrega IS NOT NULL and o.dataDevolucao IS NULL ORDER BY o.clienteCod.clienteNome")
    ,
    @NamedQuery(name = "Orcamento.orcamentoAprovadoNomeCliente", query = "SELECT o FROM Orcamento o where o.clienteCod.clienteNome like :nome AND o.dataAprovacao IS NOT NULL AND o.dataEntrega IS NULL ORDER BY o.clienteCod.clienteNome")
    ,
    @NamedQuery(name = "Orcamento.orcamentoEntregueNomeCliente", query = "SELECT o FROM Orcamento o where o.clienteCod.clienteNome like :nome AND o.dataAprovacao IS NOT NULL AND o.dataEntrega IS NOT NULL AND o.dataDevolucao IS NULL ORDER BY o.clienteCod.clienteNome")

})

public class Orcamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orcCod")
    private int orcCod;

    @Column(name = "ValorOrc")
    private double valorOrc;

    @Column(name = "cidadeEntrega", length = 75)
    private String cidadeEntrega;

    @Column(name = "ruaEntrega", length = 75)
    private String ruaEntrega;

    @Column(name = "numeroEntrega")
    private int numeroEntrega;

    @Column(name = "bairroEntrega")
    private String bairroEntrega;

    @Column(name = "dataEvento")
    @Temporal(TemporalType.DATE)
    private Date dataEvento;

    @Column(name = "dataRealizado")
    @Temporal(TemporalType.DATE)
    private Date dataRealizado;

    @Column(name = "dataVencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @Column(name = "dataAprovacao")
    @Temporal(TemporalType.DATE)
    private Date dataAprovacao;

    @Column(name = "dataEntrega")
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @Column(name = "dataDevolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;

    @Column(name = "observacao", length = 200)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "clienteCod", referencedColumnName = "clienteCod")
    private Cliente clienteCod;

    @OneToMany(mappedBy = "orcCod", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrcamentoProduto> listaOrcamento;

    public Orcamento() {
    }

    public Orcamento(int orcCod, double valorOrc, String cidadeEntrega, String ruaEntrega, int numeroEntrega, String bairroEntrega, Date dataEvento, Date dataRealizado, Date dataVencimento, Date dataAprovacao, Date dataEntrega, Date dataDevolucao, String observacao, Cliente clienteCod) {
        this.orcCod = orcCod;
        this.valorOrc = valorOrc;
        this.cidadeEntrega = cidadeEntrega;
        this.ruaEntrega = ruaEntrega;
        this.numeroEntrega = numeroEntrega;
        this.bairroEntrega = bairroEntrega;
        this.dataEvento = dataEvento;
        this.dataRealizado = dataRealizado;
        this.dataVencimento = dataVencimento;
        this.dataAprovacao = dataAprovacao;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.observacao = observacao;
        this.clienteCod = clienteCod;
    }

    public int getOrcCod() {
        return orcCod;
    }

    public void setOrcCod(int orcCod) {
        this.orcCod = orcCod;
    }

    public double getValorOrc() {
        return valorOrc;
    }

    public void setValorOrc(double valorOrc) {
        this.valorOrc = valorOrc;
    }

    public String getCidadeEntrega() {
        return cidadeEntrega;
    }

    public void setCidadeEntrega(String cidadeEntrega) {
        this.cidadeEntrega = cidadeEntrega;
    }

    public String getRuaEntrega() {
        return ruaEntrega;
    }

    public void setRuaEntrega(String ruaEntrega) {
        this.ruaEntrega = ruaEntrega;
    }

    public int getNumeroEntrega() {
        return numeroEntrega;
    }

    public void setNumeroEntrega(int numeroEntrega) {
        this.numeroEntrega = numeroEntrega;
    }

    public String getBairroEntrega() {
        return bairroEntrega;
    }

    public void setBairroEntrega(String bairroEntrega) {
        this.bairroEntrega = bairroEntrega;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Date getDataRealizado() {
        return dataRealizado;
    }

    public void setDataRealizado(Date dataRealizado) {
        this.dataRealizado = dataRealizado;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getClienteCod() {
        return clienteCod;
    }

    public void setClienteCod(Cliente clienteCod) {
        this.clienteCod = clienteCod;
    }

    public List<OrcamentoProduto> getListaOrcamento() {
        return listaOrcamento;
    }

    public double getListaValor() {
        double total = 0;
        for (OrcamentoProduto o : listaOrcamento) {
            total += o.getValor() * o.getQuantidade();
        }
        return total;
    }

    public void setListaOrcamento(List<OrcamentoProduto> listaOrcamento) {
        this.listaOrcamento = listaOrcamento;
        for (OrcamentoProduto iv : listaOrcamento) {
            iv.setOrcCod(this);
        }
    }
    
    public double getListaDevolvidoValor() {
        double total = 0;
        for (OrcamentoProduto o : listaOrcamento) {
            total += o.getValor() * (o.getQuantidade()-o.getQuantidadeDevolvida());
        }
        return total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.orcCod;
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
        final Orcamento other = (Orcamento) obj;
        if (this.orcCod != other.orcCod) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orcamento{" + "orcCod=" + orcCod + ", valorOrc=" + valorOrc + ", cidadeEntrega=" + cidadeEntrega + ", ruaEntrega=" + ruaEntrega + ", numeroEntrega=" + numeroEntrega + ", bairroEntrega=" + bairroEntrega + ", dataEvento=" + dataEvento + ", dataRealizado=" + dataRealizado + ", dataVencimento=" + dataVencimento + ", dataAprovacao=" + dataAprovacao + ", dataEntrega=" + dataEntrega + ", dataDevolucao=" + dataDevolucao + ", observacao=" + observacao + ", clienteCod=" + clienteCod + '}';
    }

}
