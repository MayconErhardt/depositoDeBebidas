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
@Table(name = "funcionario")

@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f where f.funcionarioNome is not null order by f.funcionarioNome")
    , @NamedQuery(name = "Funcionario.findByFuncionarioId", query = "SELECT f FROM Funcionario f WHERE f.funcionarioId = :funcionario")
    , @NamedQuery(name = "Funcionario.findByFuncionarioCargo", query = "SELECT f FROM Funcionario f WHERE f.funcionarioCargo = :funcionarioCargo")
    , @NamedQuery(name = "Funcionario.findByFuncionarioNome", query = "SELECT f FROM Funcionario f WHERE f.funcionarioNome like :funNome and not f.funcionarioId=:funcionarioId and f.funcionarioNome is not null order by f.funcionarioNome")
    , @NamedQuery(name = "Funcionario.findByFuncionarioCPF", query = "SELECT f FROM Funcionario f WHERE f.funcionarioCPF like :funCPF and not f.funcionarioId=:funcionarioId and f.funcionarioNome is not null")
    , @NamedQuery(name = "Funcionario.findByFuncionarioRua", query = "SELECT f FROM Funcionario f WHERE f.funcionarioRua = :funcionarioRua")
    , @NamedQuery(name = "Funcionario.findByFuncionarioNumeroRua", query = "SELECT f FROM Funcionario f WHERE f.funcionarioNumeroRua = :funcionarioNumeroRua")
    , @NamedQuery(name = "Funcionario.findByFuncionarioBairo", query = "SELECT f FROM Funcionario f WHERE f.funcionarioBairo = :funcionarioBairo")
    , @NamedQuery(name = "Funcionario.findByFuncionarioCidade", query = "SELECT f FROM Funcionario f WHERE f.funcionarioCidade = :funcionarioCidade")
    , @NamedQuery(name = "Funcionario.findByFuncionarioEstado", query = "SELECT f FROM Funcionario f WHERE f.funcionarioEstado = :funcionarioEstado")
    , @NamedQuery(name = "Funcionario.findByFuncionarioTelefone", query = "SELECT f FROM Funcionario f WHERE f.funcionarioTelefone = :funcionarioTelefone")
    , @NamedQuery(name = "Funcionario.findByFuncionarioDataNascimento", query = "SELECT f FROM Funcionario f WHERE f.funcionarioDataNascimento = :funcionarioDataNascimento")
    , @NamedQuery(name = "Funcionario.findByFuncionarioEmail", query = "SELECT f FROM Funcionario f WHERE f.funcionarioEmail = :funcionarioEmail")
    , @NamedQuery(name = "Funcionario.findByFuncionarioSenha", query = "SELECT f FROM Funcionario f WHERE f.funcionarioSenha = :funcionarioSenha")
    , @NamedQuery(name = "Funcionario.findByFuncionarioEmailIgual", query = "SELECT f FROM Funcionario f where f.funcionarioEmail = :funcionarioEmail")
    , @NamedQuery(name = "Funcionario.findByFuncionarioCPFIgual", query = "SELECT f FROM Funcionario f WHERE f.funcionarioCPF = :funCPF")
    , @NamedQuery(name = "Funcionario.achar", query = "SELECT f FROM Funcionario f WHERE f.funcionarioSenha = :senha AND f.funcionarioEmail = :email")
  //  , @NamedQuery(name = "Funcionario.buscarEu", query = "SELECT f FROM Funcionario f where f.funcionarioId= funcionario")
    , @NamedQuery(name = "Funcionario.conta", query = "SELECT count(f.funcionarioNome) FROM Funcionario f where f.funcionarioNome is not null ")
    , @NamedQuery(name = "Funcionario.semUsuario", query = "SELECT f FROM Funcionario f where not f.funcionarioId=:funcionarioId and f.funcionarioNome is not null ORDER BY f.funcionarioNome "),
        @NamedQuery(name = "Funcionario.Acessar", query = "SELECT f FROM Funcionario f WHERE f.funcionarioEmail = :email AND f.funcionarioSenha = :senha")
})


public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funCod")
    private int funcionarioId;

    @Column(name = "cargo", length = 9)
    private String funcionarioCargo;
    @Column(name = "nome", length = 45)
    private String funcionarioNome;
    @Column(name = "CPF", length = 15)
    private String funcionarioCPF;
    @Column(name = "rua", length = 45)
    private String funcionarioRua;
    @Column(name = "ruaNumero")
    private int funcionarioNumeroRua;
    @Column(name = "bairro", length = 25)
    private String funcionarioBairo;
    @Column(name = "cidade", length = 45)
    private String funcionarioCidade;
    @Column(name = "estado", length = 2)
    private String funcionarioEstado;
    @Column(name = "telefone", length = 14)
    private String funcionarioTelefone;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date funcionarioDataNascimento;

    @Column(name = "email", length = 45)
    private String funcionarioEmail;

    @Column(name = "senha", length = 20)
    private String funcionarioSenha;

    public Funcionario() {
    }

    public Funcionario(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Funcionario(int funcionarioId, String funcionarioCargo, String funcionarioEmail, String funcionarioSenha) {
        this.funcionarioId = funcionarioId;
        this.funcionarioCargo = funcionarioCargo;
        this.funcionarioEmail = funcionarioEmail;
        this.funcionarioSenha = funcionarioSenha;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getFuncionarioCargo() {
        return funcionarioCargo;
    }

    public void setFuncionarioCargo(String funcionarioCargo) {
        this.funcionarioCargo = funcionarioCargo;
    }

    public String getFuncionarioNome() {
        return funcionarioNome;
    }

    public void setFuncionarioNome(String funcionarioNome) {
        this.funcionarioNome = funcionarioNome;
    }

    public String getFuncionarioCPF() {
        return funcionarioCPF;
    }

    public void setFuncionarioCPF(String funcionarioCPF) {
        this.funcionarioCPF = funcionarioCPF;
    }

    public String getFuncionarioRua() {
        return funcionarioRua;
    }

    public void setFuncionarioRua(String funcionarioRua) {
        this.funcionarioRua = funcionarioRua;
    }

    public int getFuncionarioNumeroRua() {
        return funcionarioNumeroRua;
    }

    public void setFuncionarioNumeroRua(int funcionarioNumeroRua) {
        this.funcionarioNumeroRua = funcionarioNumeroRua;
    }

    public String getFuncionarioBairo() {
        return funcionarioBairo;
    }

    public void setFuncionarioBairo(String funcionarioBairo) {
        this.funcionarioBairo = funcionarioBairo;
    }

    public String getFuncionarioCidade() {
        return funcionarioCidade;
    }

    public void setFuncionarioCidade(String funcionarioCidade) {
        this.funcionarioCidade = funcionarioCidade;
    }

    public String getFuncionarioEstado() {
        return funcionarioEstado;
    }

    public void setFuncionarioEstado(String funcionarioEstado) {
        this.funcionarioEstado = funcionarioEstado;
    }

    public String getFuncionarioTelefone() {
        return funcionarioTelefone;
    }

    public void setFuncionarioTelefone(String funcionarioTelefone) {
        this.funcionarioTelefone = funcionarioTelefone;
    }

    public Date getFuncionarioDataNascimento() {
        return funcionarioDataNascimento;
    }

    public void setFuncionarioDataNascimento(Date funcionarioDataNascimento) {
        this.funcionarioDataNascimento = funcionarioDataNascimento;
    }

    public String getFuncionarioEmail() {
        return funcionarioEmail;
    }

    public void setFuncionarioEmail(String funcionarioEmail) {
        this.funcionarioEmail = funcionarioEmail;
    }

    public String getFuncionarioSenha() {
        return funcionarioSenha;
    }

    public void setFuncionarioSenha(String funcionarioSenha) {
        this.funcionarioSenha = funcionarioSenha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.funcionarioId;
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
        final Funcionario other = (Funcionario) obj;
        if (this.funcionarioId != other.funcionarioId) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "modelo.Funcionario[ funcionarioId=" + funcionarioId + " ]";
    }

}
