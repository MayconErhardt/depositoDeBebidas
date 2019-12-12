/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Maycon
 */
public class OrcamentoProdutoPK implements Serializable{
    
    
    
    private int orcCod;
    
    
    private int produtoCod;

    public OrcamentoProdutoPK() {
    }

    public OrcamentoProdutoPK(int orcCod, int produtoCod) {
        this.orcCod = orcCod;
        this.produtoCod = produtoCod;
    }

    public int getOrcCod() {
        return orcCod;
    }

    public void setOrcCod(int orcCod) {
        this.orcCod = orcCod;
    }

    public int getProdutoCod() {
        return produtoCod;
    }

    public void setProdutoCod(int produtoCod) {
        this.produtoCod = produtoCod;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.orcCod;
        hash = 89 * hash + this.produtoCod;
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
        final OrcamentoProdutoPK other = (OrcamentoProdutoPK) obj;
        if (this.orcCod != other.orcCod) {
            return false;
        }
        if (this.produtoCod != other.produtoCod) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrcamentoProdutoPK{" + "orcCod=" + orcCod + ", produtoCod=" + produtoCod + '}';
    }
    
    
    
    
    
    
    
    
}
