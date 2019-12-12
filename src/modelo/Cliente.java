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
@Table(name = "cliente")
@NamedQueries({
      @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c order by c.clienteNome")
    , @NamedQuery(name = "Cliente.findByClienteNome", query = "SELECT c FROM Cliente c WHERE c.clienteNome like :cliNome  order by c.clienteNome")
    , @NamedQuery(name = "Cliente.findByClienteCPF", query = "SELECT c FROM Cliente c WHERE c.clienteCPF like :cliCPF")
    , @NamedQuery(name = "Cliente.findByClienteEmailIgual", query = "SELECT c FROM Cliente c where c.clienteEmail = :cliEmail")
    , @NamedQuery(name = "Cliente.findByClienteCPFIgual", query = "SELECT c FROM Cliente c WHERE c.clienteCPF = :cliCPF")
    , @NamedQuery(name = "Cliente.listaClienteSemVendaAberta", query = "SELECT c FROM Cliente c WHERE c.clienteId  NOT IN (SELECT v.clienteCod.clienteId  FROM Venda v WHERE v.status <> 'F' and v.status <> 'P' )")
    , @NamedQuery(name = "Cliente.listaClienteSemVendaAbertaNome", query = "SELECT c FROM Cliente c WHERE c.clienteNome LIKE :nome and c.clienteId  NOT IN (SELECT v.clienteCod.clienteId  FROM Venda v WHERE v.status <> 'F' )")

})

public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clienteCod")
    private int clienteId;

    @Column(name = "nome", length = 45)
    private String clienteNome;

    @Column(name = "CPF", length = 15)
    private String clienteCPF;

    @Column(name = "RG", length = 13)
    private String clienteRG;

    @Column(name = "cidade", length = 45)
    private String clienteCidade;

    @Column(name = "rua", length = 45)
    private String clienteRua;

    @Column(name = "ruaNumero")
    private int clienteRuaNumero;

    @Column(name = "bairro", length = 45)
    private String clienteBairro;

    @Column(name = "estado", length = 2)
    private String clienteEstado;

    @Column(name = "email", length = 45)
    private String clienteEmail;

    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date clienteDataNascimento;

    @Column(name = "teleCelular", length = 14)
    private String clienteTelefoneCelular;

    public Cliente() {
    }

    public Cliente(int clienteId, String clienteNome, String clienteCPF, String clienteRG) {
        this.clienteId = clienteId;
        this.clienteNome = clienteNome;
        this.clienteCPF = clienteCPF;
        this.clienteRG = clienteRG;
    }

    public Cliente(int clienteId, String clienteNome, String clienteCPF, String clienteRG, String clienteCidade, String clienteRua, int clienteRuaNumero, String clienteBairro, String clienteEstado, String clienteEmail, Date clienteDataNascimento, String clienteTelefoneCelular) {
        this.clienteId = clienteId;
        this.clienteNome = clienteNome;
        this.clienteCPF = clienteCPF;
        this.clienteRG = clienteRG;
        this.clienteCidade = clienteCidade;
        this.clienteRua = clienteRua;
        this.clienteRuaNumero = clienteRuaNumero;
        this.clienteBairro = clienteBairro;
        this.clienteEstado = clienteEstado;
        this.clienteEmail = clienteEmail;
        this.clienteDataNascimento = clienteDataNascimento;
        this.clienteTelefoneCelular = clienteTelefoneCelular;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteCPF() {
        return clienteCPF;
    }

    public void setClienteCPF(String clienteCPF) {
        this.clienteCPF = clienteCPF;
    }

    public String getClienteRG() {
        return clienteRG;
    }

    public void setClienteRG(String clienteRG) {
        this.clienteRG = clienteRG;
    }

    public String getClienteCidade() {
        return clienteCidade;
    }

    public void setClienteCidade(String clienteCidade) {
        this.clienteCidade = clienteCidade;
    }

    public String getClienteRua() {
        return clienteRua;
    }

    public void setClienteRua(String clienteRua) {
        this.clienteRua = clienteRua;
    }

    public int getClienteRuaNumero() {
        return clienteRuaNumero;
    }

    public void setClienteRuaNumero(int clienteRuaNumero) {
        this.clienteRuaNumero = clienteRuaNumero;
    }

    public String getClienteBairro() {
        return clienteBairro;
    }

    public void setClienteBairro(String clienteBairro) {
        this.clienteBairro = clienteBairro;
    }

    public String getClienteEstado() {
        return clienteEstado;
    }

    public void setClienteEstado(String clienteEstado) {
        this.clienteEstado = clienteEstado;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public Date getClienteDataNascimento() {
        return clienteDataNascimento;
    }

    public void setClienteDataNascimento(Date clienteDataNascimento) {
        this.clienteDataNascimento = clienteDataNascimento;
    }

    public String getClienteTelefoneCelular() {
        return clienteTelefoneCelular;
    }

    public void setClienteTelefoneCelular(String clienteTelefoneCelular) {
        this.clienteTelefoneCelular = clienteTelefoneCelular;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.clienteId;
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
        final Cliente other = (Cliente) obj;
        if (this.clienteId != other.clienteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String retorno = "NOVA VENDA";
        if (clienteNome != null) {
            retorno = clienteNome;
        }
        return retorno;

    }

}
