// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sav.domain;

import java.lang.String;

privileged aspect PieceOff_Roo_ToString {
    
    public String PieceOff.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Box: ").append(getBox()).append(", ");
        sb.append("DateOfreceived: ").append(getDateOfreceived()).append(", ");
        sb.append("FailureDescription: ").append(getFailureDescription()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("NumSerie: ").append(getNumSerie()).append(", ");
        sb.append("PackingList: ").append(getPackingList()).append(", ");
        sb.append("Piece: ").append(getPiece()).append(", ");
        sb.append("Quantity: ").append(getQuantity()).append(", ");
        sb.append("Statut: ").append(getStatut()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
