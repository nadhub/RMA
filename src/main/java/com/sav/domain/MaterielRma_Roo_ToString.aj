// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sav.domain;

import java.lang.String;

privileged aspect MaterielRma_Roo_ToString {
    
    public String MaterielRma.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Action: ").append(getAction()).append(", ");
        sb.append("DateReception: ").append(getDateReception()).append(", ");
        sb.append("DateReparation: ").append(getDateReparation()).append(", ");
        sb.append("Diagnostic: ").append(getDiagnostic()).append(", ");
        sb.append("Garantie: ").append(getGarantie()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("IpSav: ").append(getIpSav()).append(", ");
        sb.append("MaterielRemplace: ").append(getMaterielRemplace()).append(", ");
        sb.append("Modele: ").append(getModele()).append(", ");
        sb.append("Notes: ").append(getNotes()).append(", ");
        sb.append("NumSerieEntree: ").append(getNumSerieEntree()).append(", ");
        sb.append("NumSerieSortie: ").append(getNumSerieSortie()).append(", ");
        sb.append("Panne: ").append(getPanne()).append(", ");
        sb.append("Projet: ").append(getProjet()).append(", ");
        sb.append("Rma: ").append(getRma()).append(", ");
        sb.append("Statut: ").append(getStatut()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
