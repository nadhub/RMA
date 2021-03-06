// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sav.domain;

import com.sav.domain.KrakRma;
import com.sav.domain.KrakRmaDataOnDemand;
import com.sav.domain.Piece;
import com.sav.domain.PieceDataOnDemand;
import com.sav.domain.PieceOff;
import com.sav.reference.StatutKrak;
import java.lang.Integer;
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

privileged aspect PieceOffDataOnDemand_Roo_DataOnDemand {
    
    declare @type: PieceOffDataOnDemand: @Component;
    
    private Random PieceOffDataOnDemand.rnd = new SecureRandom();
    
    private List<PieceOff> PieceOffDataOnDemand.data;
    
    @Autowired
    private KrakRmaDataOnDemand PieceOffDataOnDemand.krakRmaDataOnDemand;
    
    @Autowired
    private PieceDataOnDemand PieceOffDataOnDemand.pieceDataOnDemand;
    
    public PieceOff PieceOffDataOnDemand.getNewTransientPieceOff(int index) {
        PieceOff obj = new PieceOff();
        setBox(obj, index);
        setDateOfreceived(obj, index);
        setFailureDescription(obj, index);
        setNumSerie(obj, index);
        setPackingList(obj, index);
        setPiece(obj, index);
        setQuantity(obj, index);
        setStatut(obj, index);
        return obj;
    }
    
    public void PieceOffDataOnDemand.setBox(PieceOff obj, int index) {
        Integer box = new Integer(index);
        obj.setBox(box);
    }
    
    public void PieceOffDataOnDemand.setDateOfreceived(PieceOff obj, int index) {
        Date dateOfreceived = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setDateOfreceived(dateOfreceived);
    }
    
    public void PieceOffDataOnDemand.setFailureDescription(PieceOff obj, int index) {
        String failureDescription = "failureDescription_" + index;
        if (failureDescription.length() > 400) {
            failureDescription = failureDescription.substring(0, 400);
        }
        obj.setFailureDescription(failureDescription);
    }
    
    public void PieceOffDataOnDemand.setNumSerie(PieceOff obj, int index) {
        String numSerie = "numSerie_" + index;
        if (numSerie.length() > 600) {
            numSerie = numSerie.substring(0, 600);
        }
        obj.setNumSerie(numSerie);
    }
    
    public void PieceOffDataOnDemand.setPackingList(PieceOff obj, int index) {
        KrakRma packingList = krakRmaDataOnDemand.getRandomKrakRma();
        obj.setPackingList(packingList);
    }
    
    public void PieceOffDataOnDemand.setPiece(PieceOff obj, int index) {
        Piece piece = pieceDataOnDemand.getRandomPiece();
        obj.setPiece(piece);
    }
    
    public void PieceOffDataOnDemand.setQuantity(PieceOff obj, int index) {
        Integer quantity = new Integer(index);
        obj.setQuantity(quantity);
    }
    
    public void PieceOffDataOnDemand.setStatut(PieceOff obj, int index) {
        StatutKrak statut = StatutKrak.class.getEnumConstants()[0];
        obj.setStatut(statut);
    }
    
    public PieceOff PieceOffDataOnDemand.getSpecificPieceOff(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        PieceOff obj = data.get(index);
        return PieceOff.findPieceOff(obj.getId());
    }
    
    public PieceOff PieceOffDataOnDemand.getRandomPieceOff() {
        init();
        PieceOff obj = data.get(rnd.nextInt(data.size()));
        return PieceOff.findPieceOff(obj.getId());
    }
    
    public boolean PieceOffDataOnDemand.modifyPieceOff(PieceOff obj) {
        return false;
    }
    
    public void PieceOffDataOnDemand.init() {
        data = PieceOff.findPieceOffEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'PieceOff' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<com.sav.domain.PieceOff>();
        for (int i = 0; i < 10; i++) {
            PieceOff obj = getNewTransientPieceOff(i);
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
