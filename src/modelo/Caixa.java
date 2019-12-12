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
@Table(name = "caixa")
@NamedQueries({
    @NamedQuery(name = "Caixa.buscaAberto", query = "SELECT c FROM Caixa c where c.horaFecha is null")
    ,
    @NamedQuery(name = "Caixa.buscarRecebimento", query = "SELECT c FROM Caixa c where c.caixaCod =:codigo")

// , @NamedQuery(name = "Cliente.findByClienteId", query = "SELECT f FROM Funcionario f WHERE f.funcionarioId = :funcionarioId")
})
public class Caixa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caixaCod")
    private int caixaCod;

    @Column(name = "dataAbertura")
    @Temporal(TemporalType.DATE)
    private Date dataAbertura;

    @Column(name = "horaAbertura")
    @Temporal(TemporalType.TIME)
    private Date horaAbertura;

    @Column(name = "valorAbertura")
    private double valorAbertura;

    @Column(name = "dataFecha")
    @Temporal(TemporalType.DATE)
    private Date dataFecha;

    @Column(name = "horaFecha")
    @Temporal(TemporalType.TIME)
    private Date horaFecha;

    @Column(name = "valorFecha", nullable = true)
    private Double valorFecha;

    @ManyToOne
    @JoinColumn(name = "funcionarioCod", referencedColumnName = "funCod")
    private Funcionario funcionarioCod;

    @OneToMany(mappedBy = "caixaCod", cascade = CascadeType.REFRESH)
    private List<Recebimento> listCaixa;

    @OneToMany(mappedBy = "caixaCod", cascade = CascadeType.REFRESH)
    private List<Pagamento> listPagamento;

    public Caixa() {
        
    }

    public Caixa(int caixaCod, Date dataAbertura, Date horaAbertura, double valorAbertura, Date dataFecha, Date horaFecha, Double valorFecha, Funcionario funcionarioCod) {
        this.caixaCod = caixaCod;
        this.dataAbertura = dataAbertura;
        this.horaAbertura = horaAbertura;
        this.valorAbertura = valorAbertura;
        this.dataFecha = dataFecha;
        this.horaFecha = horaFecha;
        this.valorFecha = valorFecha;
        this.funcionarioCod = funcionarioCod;
    }

    public int getCaixaCod() {
        return caixaCod;
    }

    public void setCaixaCod(int caixaCod) {
        this.caixaCod = caixaCod;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(Date horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public double getValorAbertura() {
        return valorAbertura;
    }

    public void setValorAbertura(double valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public Date getDataFecha() {
        return dataFecha;
    }

    public void setDataFecha(Date dataFecha) {
        this.dataFecha = dataFecha;
    }

    public Date getHoraFecha() {
        return horaFecha;
    }

    public void setHoraFecha(Date horaFecha) {
        this.horaFecha = horaFecha;
    }

    public Double getValorFecha() {
        return valorFecha;
    }

    public void setValorFecha(Double valorFecha) {
        this.valorFecha = valorFecha;
    }

    public Funcionario getFuncionarioCod() {
        return funcionarioCod;
    }

    public void setFuncionarioCod(Funcionario funcionarioCod) {
        this.funcionarioCod = funcionarioCod;
    }

    public List<Recebimento> getListCaixa() {
        return listCaixa;
    }

    public List<Pagamento> getListPagamento() {
        return listPagamento;
    }

    public void setListPagamento(List<Pagamento> listPagamento) {
        this.listPagamento = listPagamento;
    }

    public void setListCaixa(List<Recebimento> listCaixa) {
        this.listCaixa = listCaixa;
        for (Recebimento ic : this.getListCaixa()) {
            ic.setCaixaCod(this);
            // pag.seDescricao("Parcela nr." + pag.nrmero+" da nf nr. " +this.notaFiscalFornecedor + "do fornecedor"+ this.fornecedorCod.getFornecedorRazaoSicial())
            ;
        }
    }

    public double getValorCartao() {
        double valor = 0;
        for (Recebimento r : listCaixa) {
            if (r.getFormaRecebimento() == 'C') {

                valor += r.getValorRecebido();
            }
        }
        return valor;
    }

    public double getValorDinheiro() {
        double valor = 0;
        for (Recebimento r : listCaixa) {
            if (r.getFormaRecebimento() == 'D') {

                valor += r.getValorRecebido();
            }
        }
        return valor;
    }

    public double getValorTotal() {
        double valor = 0;
        for (Recebimento r : listCaixa) {

            valor += r.getValorRecebido();

        }
        return valor;
    }

    public double getValorCompra() {
        double valor = 0;
        for (Pagamento p : listPagamento) {

            if (p.getCompraProduto() != null) {
                valor += p.getValorPagar();
            }

        }
        return valor;
    }

    public double getValorConta() {
        double valor = 0;
        for (Pagamento p : listPagamento) {

            if (p.getCompraProduto() == null) {
                valor += p.getValorPagar();
            }

        }
        return valor;
    }

    public double getTotalPagamento() {
        double valor = 0;
        for (Pagamento p : listPagamento) {

            valor += p.getValorPagar();

        }
        return valor;
    }

    public void setListaRecebimento(List<Recebimento> recebimento) {
        this.listCaixa = recebimento;
        for (Recebimento r : listCaixa) {
            r.setCaixaCod(this);
        }
    }

    @Override
    public String toString() {
        return "Caixa{" + "caixaCod=" + caixaCod + ", dataAbertura=" + dataAbertura + ", horaAbertura=" + horaAbertura + ", valorAbertura=" + valorAbertura + ", dataFecha=" + dataFecha + ", horaFecha=" + horaFecha + ", valorFecha=" + valorFecha + ", funcionarioCod=" + funcionarioCod + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.caixaCod;
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
        final Caixa other = (Caixa) obj;
        if (this.caixaCod != other.caixaCod) {
            return false;
        }
        return true;
    }

}
