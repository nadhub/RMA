// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sav.domain;

import com.sav.domain.AdressRetour;
import java.lang.String;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

privileged aspect AdressRetourDataOnDemand_Roo_DataOnDemand {
    
    declare @type: AdressRetourDataOnDemand: @Component;
    
    private Random AdressRetourDataOnDemand.rnd = new SecureRandom();
    
    private List<AdressRetour> AdressRetourDataOnDemand.data;
    
    public AdressRetour AdressRetourDataOnDemand.getNewTransientAdressRetour(int index) {
        AdressRetour obj = new AdressRetour();
        setAdresse1(obj, index);
        setAdresse2(obj, index);
        setAdresseRetour(obj, index);
        setCodePostal(obj, index);
        setContact(obj, index);
        setEmail(obj, index);
        setPays(obj, index);
        setRegion(obj, index);
        setTel(obj, index);
        setVille(obj, index);
        return obj;
    }
    
    public void AdressRetourDataOnDemand.setAdresse1(AdressRetour obj, int index) {
        String adresse1 = "adresse1_" + index;
        if (adresse1.length() > 100) {
            adresse1 = adresse1.substring(0, 100);
        }
        obj.setAdresse1(adresse1);
    }
    
    public void AdressRetourDataOnDemand.setAdresse2(AdressRetour obj, int index) {
        String adresse2 = "adresse2_" + index;
        if (adresse2.length() > 100) {
            adresse2 = adresse2.substring(0, 100);
        }
        obj.setAdresse2(adresse2);
    }
    
    public void AdressRetourDataOnDemand.setAdresseRetour(AdressRetour obj, int index) {
        String adresseRetour = "adresseRetour_" + index;
        obj.setAdresseRetour(adresseRetour);
    }
    
    public void AdressRetourDataOnDemand.setCodePostal(AdressRetour obj, int index) {
        String codePostal = "codePostal_" + index;
        obj.setCodePostal(codePostal);
    }
    
    public void AdressRetourDataOnDemand.setContact(AdressRetour obj, int index) {
        String contact = "contact_" + index;
        obj.setContact(contact);
    }
    
    public void AdressRetourDataOnDemand.setEmail(AdressRetour obj, int index) {
        String email = "email_" + index;
        obj.setEmail(email);
    }
    
    public void AdressRetourDataOnDemand.setPays(AdressRetour obj, int index) {
        String Pays = "Pays_" + index;
        obj.setPays(Pays);
    }
    
    public void AdressRetourDataOnDemand.setRegion(AdressRetour obj, int index) {
        String region = "region_" + index;
        obj.setRegion(region);
    }
    
    public void AdressRetourDataOnDemand.setTel(AdressRetour obj, int index) {
        String tel = "tel_" + index;
        obj.setTel(tel);
    }
    
    public void AdressRetourDataOnDemand.setVille(AdressRetour obj, int index) {
        String ville = "ville_" + index;
        obj.setVille(ville);
    }
    
    public AdressRetour AdressRetourDataOnDemand.getSpecificAdressRetour(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        AdressRetour obj = data.get(index);
        return AdressRetour.findAdressRetour(obj.getId());
    }
    
    public AdressRetour AdressRetourDataOnDemand.getRandomAdressRetour() {
        init();
        AdressRetour obj = data.get(rnd.nextInt(data.size()));
        return AdressRetour.findAdressRetour(obj.getId());
    }
    
    public boolean AdressRetourDataOnDemand.modifyAdressRetour(AdressRetour obj) {
        return false;
    }
    
    public void AdressRetourDataOnDemand.init() {
        data = AdressRetour.findAdressRetourEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'AdressRetour' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<com.sav.domain.AdressRetour>();
        for (int i = 0; i < 10; i++) {
            AdressRetour obj = getNewTransientAdressRetour(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> it = e.getConstraintViolations().iterator(); it.hasNext();) {
                    ConstraintViolation<?> cv = it.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
