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
public class ItemVendaPK implements Serializable{
    

    private int nrItem;


    private int vendaCod;

    public ItemVendaPK() {
    }

    public ItemVendaPK(int nrItem, int vendaCod) {
        this.nrItem = nrItem;
        this.vendaCod = vendaCod;
    }

    public int getNrItem() {
        return nrItem;
    }

    public void setNrItem(int nrItem) {
        this.nrItem = nrItem;
    }

    public int getVendaCod() {
        return vendaCod;
    }

    public void setVendaCod(int vendaCod) {
        this.vendaCod = vendaCod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.nrItem;
        hash = 67 * hash + this.vendaCod;
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
        final ItemVendaPK other = (ItemVendaPK) obj;
        if (this.nrItem != other.nrItem) {
            return false;
        }
        if (this.vendaCod != other.vendaCod) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemVendaPK{" + "nrItem=" + nrItem + ", vendaCod=" + vendaCod + '}';
    }
    
    
    
    
    
    
    
    
}
