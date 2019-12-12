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
public class PagamendoPK implements Serializable{
    
    private int pagCod;
 
    private int numeroParcela;

    public PagamendoPK() {
    }

    public PagamendoPK(int pagCod, int numeroParcela) {
        this.pagCod = pagCod;
        this.numeroParcela = numeroParcela;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.pagCod;
        hash = 31 * hash + this.numeroParcela;
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
        final PagamendoPK other = (PagamendoPK) obj;
        if (this.pagCod != other.pagCod) {
            return false;
        }
        if (this.numeroParcela != other.numeroParcela) {
            return false;
        }
        return true;
    }
    
    
    
}
