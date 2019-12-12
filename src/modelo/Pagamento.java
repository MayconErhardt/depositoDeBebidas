package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Maycon
 */
@Entity
@Table(name = "pagamento")

@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p where p.dataPaga IS NULL order by p.descricao,p.dataVencimento")
    ,                                                                                                                                     
    @NamedQuery(name = "Pagamento.findNome", query = "SELECT p FROM Pagamento p WHERE p.descricao like :descricao and p.dataPaga IS NULL order by p.dataVencimento, p.descricao")
    ,
    @NamedQuery(name = "Pagamento.porPeriodo", query = "SELECT p FROM Pagamento p WHERE p.dataVencimento BETWEEN  :dataIni and :dataFim AND p.dataPaga IS NULL ORDER BY p.dataVencimento, p.descricao")
    ,
    @NamedQuery(name = "Pagamento.porPeriodoConta", query = "SELECT p FROM Pagamento p where p.descricao like :descricao and p.dataVencimento BETWEEN :dataIni and :dataFim AND p.dataPaga IS NULL ORDER BY p.dataVencimento,p.descricao")
    ,
    @NamedQuery(name = "Pagamento.findAllContaPaga", query = "SELECT p FROM Pagamento p where p.dataPaga IS NOT NULL order by p.descricao,p.dataVencimento")
    ,
    @NamedQuery(name = "Pagamento.findNomePagas", query = "SELECT p FROM Pagamento p where p.descricao like :descricao and p.dataPaga IS NOT NULL order by p.dataVencimento, p.descricao")
    ,
    @NamedQuery(name = "Pagamento.porPeriodoContaPagas", query = "SELECT p FROM Pagamento p where p.descricao like :descricao and p.dataPaga BETWEEN :dataIni and :dataFim AND p.dataPaga IS NOT NULL ORDER BY p.dataVencimento,p.descricao")
    ,
    @NamedQuery(name = "Pagamento.porPeriodoPagas", query = "SELECT p FROM Pagamento p WHERE p.dataPaga BETWEEN  :dataIni and :dataFim AND p.dataPaga IS NOT NULL ORDER BY p.dataVencimento, p.descricao")
    ,
    @NamedQuery(name = "Pagamento.contaSemCompra", query = "SELECT p FROM Pagamento p where p.compraProduto = NULL and p.dataPaga IS NULL")
    ,
    @NamedQuery(name = "Pagamento.porPeriodoaPagarRelatorio", query = "SELECT p FROM Pagamento p WHERE p.dataVencimento BETWEEN  :dataIni and :dataFim AND p.dataPaga IS NULL ORDER BY p.dataVencimento, p.descricao")
    ,
    @NamedQuery(name = "Pagamento.findContaPorNome", query = "SELECT p FROM Pagamento p WHERE p.descricao like :descricao AND p.compraProduto =NULL AND p.dataPaga IS NULL")

})
@IdClass(PagamendoPK.class)
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pagCod")
    private int pagCod;

    @Id
    @Column(name = "numeroParcela")
    private int numeroParcela;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataPaga")
    private Date dataPaga;

    @Column(name = "descricao", length = 100)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataVencimento")
    private Date dataVencimento;

    @Column(name = "valorPagar")
    private double valorPagar;

    @Column(name = "juros")
    private double juros;

    @Column(name = "desconto")
    private double desconto;

    @Column(name = "observacao", length = 45)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "caixaCod", referencedColumnName = "caixaCod")
    private Caixa caixaCod;

    @ManyToOne
    @JoinColumn(name = "compraProdutoCod", referencedColumnName = "compraCod")
    private CompraProduto compraProduto;

    public Pagamento() {
    }

    public Pagamento(int pagCod, int numeroParcela, Date dataPaga, String descricao, Date dataVencimento, double valorPagar, double juros, double desconto, String observacao, Caixa caixa, CompraProduto compraProduto) {
        this.pagCod = pagCod;
        this.numeroParcela = numeroParcela;
        this.dataPaga = dataPaga;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.valorPagar = valorPagar;
        this.juros = juros;
        this.desconto = desconto;
        this.observacao = observacao;
        this.caixaCod = caixa;
        this.compraProduto = compraProduto;
    }

    public int getPagCod() {
        return pagCod;
    }

    public void setPagCod(int pagCod) {
        this.pagCod = pagCod;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(int numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public Date getDataPaga() {
        return dataPaga;
    }

    public void setDataPaga(Date dataPaga) {
        this.dataPaga = dataPaga;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Caixa getCaixa() {
        return caixaCod;
    }

    public void setCaixa(Caixa caixa) {
        this.caixaCod = caixa;
    }

    public CompraProduto getCompraProduto() {
        return compraProduto;
    }

    public void setCompraProduto(CompraProduto compraProduto) {
        this.compraProduto = compraProduto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.pagCod;
        hash = 89 * hash + this.numeroParcela;
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
        final Pagamento other = (Pagamento) obj;
        if (this.pagCod != other.pagCod) {
            return false;
        }
        if (this.numeroParcela != other.numeroParcela) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "pagCod=" + pagCod + ", numeroParcela=" + numeroParcela + ", dataPaga=" + dataPaga + ", descricao=" + descricao + ", dataVencimento=" + dataVencimento + ", valorPagar=" + valorPagar + ", juros=" + juros + ", desconto=" + desconto + ", observacao=" + observacao + ", caixa=" + caixaCod + ", compraProduto=" + compraProduto + '}';
    }

}
