/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Maycon
 */
@Entity
@Table(name="fornecedor")
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f order by f.fornecedorNomeFantasia")
    , @NamedQuery(name = "Fornecedor.findByFornecedorNome", query = "SELECT f FROM Fornecedor f WHERE f.forncedorNomeContato like :forNome  order by f.forncedorNomeContato")
    , @NamedQuery(name = "Fornecedor.findByFornecedorEmailIgual", query = "SELECT f FROM Fornecedor f where f.fornecedorEmail = :forEmail")
    
})
public class Fornecedor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fornecedorCod")
    private int forncedorID;
    @Column(name = "razaoSicial",length = 45)
    private String fornecedorRazaoSicial;
    @Column(name = "nomeFantasia",length = 45)
    private String fornecedorNomeFantasia;
    @Column(name = "email",length = 45)
    private String fornecedorEmail;
    @Column(name = "CNPJ",length = 15)
    private String fornecedorCNPJ;
    
    @Column(name = "cidade",length = 45)
    private String fornecedorCidade;
    @Column(name = "estado",length = 2)
    private String fornecedorEstado;
    @Column(name = "nomeContato",length = 45)
    private String forncedorNomeContato;
    @Column(name = "telefoneCelular",length = 14)
    private String fornecedorTelefoneCelular;

    public Fornecedor() {
    }

    public Fornecedor(int forncedorID, String fornecedorRazaoSicial, String fornecedorNomeFantasia, String fornecedorEmail, String fornecedorCNPJ, String fornecedorCidade, String fornecedorEstado, String forncedorNomeContato, String fornecedorTelefoneCelular) {
        this.forncedorID = forncedorID;
        this.fornecedorRazaoSicial = fornecedorRazaoSicial;
        this.fornecedorNomeFantasia = fornecedorNomeFantasia;
        this.fornecedorEmail = fornecedorEmail;
        this.fornecedorCNPJ = fornecedorCNPJ;
        this.fornecedorCidade = fornecedorCidade;
        this.fornecedorEstado = fornecedorEstado;
        this.forncedorNomeContato = forncedorNomeContato;
        this.fornecedorTelefoneCelular = fornecedorTelefoneCelular;
    }

    public int getForncedorID() {
        return forncedorID;
    }

    public void setForncedorID(int forncedorID) {
        this.forncedorID = forncedorID;
    }

    public String getFornecedorRazaoSicial() {
        return fornecedorRazaoSicial;
    }

    public void setFornecedorRazaoSicial(String fornecedorRazaoSicial) {
        this.fornecedorRazaoSicial = fornecedorRazaoSicial;
    }

    public String getFornecedorNomeFantasia() {
        return fornecedorNomeFantasia;
    }

    public void setFornecedorNomeFantasia(String fornecedorNomeFantasia) {
        this.fornecedorNomeFantasia = fornecedorNomeFantasia;
    }

    public String getFornecedorEmail() {
        return fornecedorEmail;
    }

    public void setFornecedorEmail(String fornecedorEmail) {
        this.fornecedorEmail = fornecedorEmail;
    }

    public String getFornecedorCNPJ() {
        return fornecedorCNPJ;
    }

    public void setFornecedorCNPJ(String fornecedorCNPJ) {
        this.fornecedorCNPJ = fornecedorCNPJ;
    }

    public String getFornecedorCidade() {
        return fornecedorCidade;
    }

    public void setFornecedorCidade(String fornecedorCidade) {
        this.fornecedorCidade = fornecedorCidade;
    }

    public String getFornecedorEstado() {
        return fornecedorEstado;
    }

    public void setFornecedorEstado(String fornecedorEstado) {
        this.fornecedorEstado = fornecedorEstado;
    }

    public String getForncedorNomeContato() {
        return forncedorNomeContato;
    }

    public void setForncedorNomeContato(String forncedorNomeContato) {
        this.forncedorNomeContato = forncedorNomeContato;
    }

    public String getFornecedorTelefoneCelular() {
        return fornecedorTelefoneCelular;
    }

    public void setFornecedorTelefoneCelular(String fornecedorTelefoneCelular) {
        this.fornecedorTelefoneCelular = fornecedorTelefoneCelular;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.forncedorID;
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
        final Fornecedor other = (Fornecedor) obj;
        if (this.forncedorID != other.forncedorID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "fornecedorRazaoSicial=" + fornecedorRazaoSicial + '}';
    }


}
