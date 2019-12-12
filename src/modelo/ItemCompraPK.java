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
public class ItemCompraPK implements Serializable{

     
    
    private int produtoCod;
    private int compraCod;

    public ItemCompraPK() {
    }

    public ItemCompraPK(int produtoCod, int compraCod) {
        this.produtoCod = produtoCod;
        this.compraCod = compraCod;
    }

    public int getProdutoCod() {
        return produtoCod;
    }

    public void setProdutoCod(int produtoCod) {
        this.produtoCod = produtoCod;
    }

    public int getCompraCod() {
        return compraCod;
    }

    public void setCompraCod(int compraCod) {
        this.compraCod = compraCod;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.produtoCod;
        hash = 17 * hash + this.compraCod;
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
        final ItemCompraPK other = (ItemCompraPK) obj;
        if (this.produtoCod != other.produtoCod) {
            return false;
        }
        if (this.compraCod != other.compraCod) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemCompraPK{" + "produtoCod=" + produtoCod + ", compraCod=" + compraCod + '}';
    }

    
    

    
    

    
    
   
    
    
    
    
}
