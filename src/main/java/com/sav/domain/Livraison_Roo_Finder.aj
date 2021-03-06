// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sav.domain;

import com.sav.domain.Livraison;
import com.sav.domain.MaterielRma;
import java.lang.String;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect Livraison_Roo_Finder {
    
    public static TypedQuery<Livraison> Livraison.findLivraisonsByMaterielRma(MaterielRma materielRma) {
        if (materielRma == null) throw new IllegalArgumentException("The materielRma argument is required");
        EntityManager em = Livraison.entityManager();
        TypedQuery<Livraison> q = em.createQuery("SELECT o FROM Livraison AS o WHERE o.materielRma = :materielRma", Livraison.class);
        q.setParameter("materielRma", materielRma);
        return q;
    }
    
    public static TypedQuery<Livraison> Livraison.findLivraisonsByReferenceEquals(String reference) {
        if (reference == null || reference.length() == 0) throw new IllegalArgumentException("The reference argument is required");
        EntityManager em = Livraison.entityManager();
        TypedQuery<Livraison> q = em.createQuery("SELECT o FROM Livraison AS o WHERE o.reference = :reference", Livraison.class);
        q.setParameter("reference", reference);
        return q;
    }
    
}
