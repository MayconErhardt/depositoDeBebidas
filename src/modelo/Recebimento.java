/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "recebimento")
@NamedQueries({
    @NamedQuery(name = "Receber.buscarContaRecebida", query = "SELECT SUM(r.valorRecebido) FROM Recebimento r WHERE r.vendaCod.vendaCod = :codValor")
    ,@NamedQuery(name = "Recebimento.findByBuscaCaixaRecebimento", query = "SELECT r FROM Recebimento r WHERE r.caixaCod = :codCaixa")
})
public class Recebimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receCod")
    private int recebimentoCod;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date dataRecebimento;

    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date horaRecebimento;

    @Column(name = "valorRecebido")
    private double valorRecebido;

    @Column(name = "formaRecebimento")
    private char formaRecebimento;

    @Column(name = "observa")
    private String oberservacao;

    @ManyToOne
    @JoinColumn(name = "caixaCod", referencedColumnName = "caixaCod")
    private Caixa caixaCod;

    @ManyToOne
    @JoinColumn(name = "vendaCod", referencedColumnName = "vendaCod")
    private Venda vendaCod;

    public Recebimento() {
    }

    public Recebimento(int recebimentoCod, Date dataRecebimento, Date horaRecebimento, double valorRecebido, char formaRecebimento, Caixa caixaCod, Venda vendaCod) {
        this.recebimentoCod = recebimentoCod;
        this.dataRecebimento = dataRecebimento;
        this.horaRecebimento = horaRecebimento;
        this.valorRecebido = valorRecebido;
        this.formaRecebimento = formaRecebimento;
        this.caixaCod = caixaCod;
        this.vendaCod = vendaCod;
    }

    public int getRecebimentoCod() {
        return recebimentoCod;
    }

    public void setRecebimentoCod(int recebimentoCod) {
        this.recebimentoCod = recebimentoCod;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getHoraRecebimento() {
        return horaRecebimento;
    }

    public void setHoraRecebimento(Date horaRecebimento) {
        this.horaRecebimento = horaRecebimento;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public char getFormaRecebimento() {
        return formaRecebimento;
    }

    public void setFormaRecebimento(char formaRecebimento) {
        this.formaRecebimento = formaRecebimento;
    }

    public Caixa getCaixaCod() {
        return caixaCod;
    }

    public void setCaixaCod(Caixa caixaCod) {
        this.caixaCod = caixaCod;
    }

    public Venda getVendaCod() {
        return vendaCod;
    }

    public void setVendaCod(Venda vendaCod) {
        this.vendaCod = vendaCod;
    }

    public String getOberservacao() {
        return oberservacao;
    }

    public void setOberservacao(String oberservacao) {
        this.oberservacao = oberservacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.recebimentoCod;
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
        final Recebimento other = (Recebimento) obj;
        if (this.recebimentoCod != other.recebimentoCod) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recebimento{" + "recebimentoCod=" + recebimentoCod + ", dataRecebimento=" + dataRecebimento + ", horaRecebimento=" + horaRecebimento + ", valorRecebido=" + valorRecebido + ", formaRecebimento=" + formaRecebimento + ", caixaCod=" + caixaCod + ", vendaCod=" + vendaCod + '}';
    }

}
