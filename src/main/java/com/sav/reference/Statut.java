package com.sav.reference;


public enum Statut {

A_REPARER, PRET_A_LIVRER, CLOS;
    
    @Override
    public String toString() {
        return name().replace("_", " ");
    }
}
