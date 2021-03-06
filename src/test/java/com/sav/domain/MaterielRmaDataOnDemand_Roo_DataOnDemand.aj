// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sav.domain;

import com.sav.domain.MaterielRma;
import com.sav.domain.Produit;
import com.sav.domain.ProduitDataOnDemand;
import com.sav.domain.Rma;
import com.sav.domain.RmaDataOnDemand;
import com.sav.reference.Projet;
import com.sav.reference.Statut;
import java.lang.Boolean;
import java.lang.String;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect MaterielRmaDataOnDemand_Roo_DataOnDemand {
    
    declare @type: MaterielRmaDataOnDemand: @Component;
    
    private Random MaterielRmaDataOnDemand.rnd = new SecureRandom();
    
    private List<MaterielRma> MaterielRmaDataOnDemand.data;
    
    @Autowired
    private ProduitDataOnDemand MaterielRmaDataOnDemand.produitDataOnDemand;
    
    @Autowired
    private RmaDataOnDemand MaterielRmaDataOnDemand.rmaDataOnDemand;
    
    public MaterielRma MaterielRmaDataOnDemand.getNewTransientMaterielRma(int index) {
        MaterielRma obj = new MaterielRma();
        setAction(obj, index);
        setDateReception(obj, index);
        setDateReparation(obj, index);
        setDiagnostic(obj, index);
        setGarantie(obj, index);
        setIpSav(obj, index);
        setMaterielRemplace(obj, index);
        setModele(obj, index);
        setNotes(obj, index);
        setNumSerieEntree(obj, index);
        setNumSerieSortie(obj, index);
        setPanne(obj, index);
        setProjet(obj, index);
        setRma(obj, index);
        setStatut(obj, index);
        return obj;
    }
    
    public void MaterielRmaDataOnDemand.setAction(MaterielRma obj, int index) {
        String action = "action_" + index;
        if (action.length() > 300) {
            action = action.substring(0, 300);
        }
        obj.setAction(action);
    }
    
    public void MaterielRmaDataOnDemand.setDateReception(MaterielRma obj, int index) {
        Date dateReception = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setDateReception(dateReception);
    }
    
    public void MaterielRmaDataOnDemand.setDateReparation(MaterielRma obj, int index) {
        Date dateReparation = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setDateReparation(dateReparation);
    }
    
    public void MaterielRmaDataOnDemand.setDiagnostic(MaterielRma obj, int index) {
        String diagnostic = "diagnostic_" + index;
        if (diagnostic.length() > 300) {
            diagnostic = diagnostic.substring(0, 300);
        }
        obj.setDiagnostic(diagnostic);
    }
    
    public void MaterielRmaDataOnDemand.setGarantie(MaterielRma obj, int index) {
        Boolean garantie = Boolean.TRUE;
        obj.setGarantie(garantie);
    }
    
    public void MaterielRmaDataOnDemand.setIpSav(MaterielRma obj, int index) {
        String ipSav = "ipSav_" + index;
        obj.setIpSav(ipSav);
    }
    
    public void MaterielRmaDataOnDemand.setMaterielRemplace(MaterielRma obj, int index) {
        Boolean materielRemplace = Boolean.TRUE;
        obj.setMaterielRemplace(materielRemplace);
    }
    
    public void MaterielRmaDataOnDemand.setModele(MaterielRma obj, int index) {
        Produit modele = produitDataOnDemand.getRandomProduit();
        obj.setModele(modele);
    }
    
    public void MaterielRmaDataOnDemand.setNotes(MaterielRma obj, int index) {
        String notes = "notes_" + index;
        if (notes.length() > 300) {
            notes = notes.substring(0, 300);
        }
        obj.setNotes(notes);
    }
    
    public void MaterielRmaDataOnDemand.setNumSerieEntree(MaterielRma obj, int index) {
        String numSerieEntree = "numSerieEntree_" + index;
        obj.setNumSerieEntree(numSerieEntree);
    }
    
    public void MaterielRmaDataOnDemand.setNumSerieSortie(MaterielRma obj, int index) {
        String numSerieSortie = "numSerieSortie_" + index;
        obj.setNumSerieSortie(numSerieSortie);
    }
    
    public void MaterielRmaDataOnDemand.setPanne(MaterielRma obj, int index) {
        String panne = "panne_" + index;
        if (panne.length() > 300) {
            panne = panne.substring(0, 300);
        }
        obj.setPanne(panne);
    }
    
    public void MaterielRmaDataOnDemand.setProjet(MaterielRma obj, int index) {
        Projet projet = Projet.class.getEnumConstants()[0];
        obj.setProjet(projet);
    }
    
    public void MaterielRmaDataOnDemand.setRma(MaterielRma obj, int index) {
        Rma rma = rmaDataOnDemand.getRandomRma();
        obj.setRma(rma);
    }
    
    public void MaterielRmaDataOnDemand.setStatut(MaterielRma obj, int index) {
        Statut statut = Statut.class.getEnumConstants()[0];
        obj.setStatut(statut);
    }
    
    public MaterielRma MaterielRmaDataOnDemand.getSpecificMaterielRma(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        MaterielRma obj = data.get(index);
        return MaterielRma.findMaterielRma(obj.getId());
    }
    
    public MaterielRma MaterielRmaDataOnDemand.getRandomMaterielRma() {
        init();
        MaterielRma obj = data.get(rnd.nextInt(data.size()));
        return MaterielRma.findMaterielRma(obj.getId());
    }
    
    public boolean MaterielRmaDataOnDemand.modifyMaterielRma(MaterielRma obj) {
        return false;
    }
    
    public void MaterielRmaDataOnDemand.init() {
        data = MaterielRma.findMaterielRmaEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'MaterielRma' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<com.sav.domain.MaterielRma>();
        for (int i = 0; i < 10; i++) {
            MaterielRma obj = getNewTransientMaterielRma(i);
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
