// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sav.domain;

import java.lang.String;

privileged aspect Client_Roo_ToString {
    
    public String Client.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Adresse1: ").append(getAdresse1()).append(", ");
        sb.append("Adresse2: ").append(getAdresse2()).append(", ");
        sb.append("Client: ").append(getClient()).append(", ");
        sb.append("CodePostal: ").append(getCodePostal()).append(", ");
        sb.append("Contact: ").append(getContact()).append(", ");
        sb.append("Email: ").append(getEmail()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Pays: ").append(getPays()).append(", ");
        sb.append("Region: ").append(getRegion()).append(", ");
        sb.append("Tel: ").append(getTel()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Ville: ").append(getVille());
        return sb.toString();
    }
    
}