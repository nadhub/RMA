// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sav.domain;

import com.sav.domain.MaterielRma;
import com.sav.reference.Transport;
import java.lang.String;
import java.util.Date;

privileged aspect Livraison_Roo_JavaBean {
    
    public Date Livraison.getDateLivraison() {
        return this.dateLivraison;
    }
    
    public void Livraison.setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }
    
    public MaterielRma Livraison.getMaterielRma() {
        return this.materielRma;
    }
    
    public void Livraison.setMaterielRma(MaterielRma materielRma) {
        this.materielRma = materielRma;
    }
    
    public Transport Livraison.getTransport() {
        return this.transport;
    }
    
    public void Livraison.setTransport(Transport transport) {
        this.transport = transport;
    }
    
    public String Livraison.getTrackingNumber() {
        return this.trackingNumber;
    }
    
    public void Livraison.setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
    
}
