package com.sav.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.format.annotation.DateTimeFormat;
import com.sav.domain.MaterielRma;
import javax.persistence.ManyToOne;

import com.sav.reference.Projet;
import com.sav.reference.Statut;
import com.sav.reference.Transport;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findLivraisonsByReferenceEquals", "findLivraisonsByMaterielRma" })
public class Livraison {

    private transient Long livGenereNumber;

    @NotNull
    @Column(unique = true)
    private String reference;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dateLivraison;

    @NotNull
    @ManyToOne
    private MaterielRma materielRma;

    @Enumerated
    private Transport transport;

    private String trackingNumber;

    public static long countYearLivraison() {
        EntityManager em = entityManager();
        return em.createQuery("SELECT COUNT(o) FROM Livraison o WHERE (YEAR(o.dateLivraison) = (YEAR(sysdate())))", Long.class).getSingleResult();
    }

    public Long getLivGenereNumber() {
        livGenereNumber = countYearLivraison() + 1;
        return livGenereNumber;
    }

    public String getReference() {
        if (reference == null) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
            String delivrYear = sdf1.format(Calendar.getInstance().getTime());
            reference = "BR-" + delivrYear + "/" + getLivGenereNumber();
        }
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public static TypedQuery<Livraison> findLivraisonsById(Long id) {
        if (id == null) throw new IllegalArgumentException("The id argument is required");
        EntityManager em = entityManager();
        TypedQuery<Livraison> q = em.createQuery("SELECT o FROM Livraison AS o WHERE o.id = :id", Livraison.class);
        q.setParameter("id", id);
        return q;
    }

	public static TypedQuery<Livraison> findLivraisonsByAdressRetour(AdressRetour adressRetour) {
        if (adressRetour == null) throw new IllegalArgumentException("This address argument is required");
        EntityManager em = Livraison.entityManager();
        TypedQuery<Livraison> q = em.createQuery("SELECT o FROM Livraison AS o WHERE o.materielRma.rma.adresseDeRetour = :adressRetour ORDER BY o.dateLivraison", Livraison.class);
        q.setParameter("adressRetour", adressRetour);
        return q;
    }

	public static List<Livraison> findAllLivraisons() {
        return entityManager().createQuery("SELECT o FROM Livraison o ORDER BY o.dateLivraison desc", Livraison.class).getResultList();
    }

	public static List<Livraison> findLivraisonEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Livraison o ORDER BY o.dateLivraison desc", Livraison.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
	
	public static TypedQuery<Livraison> findLivraisonsByProjetAndStatut(Projet projet, Statut statut) {
        if (projet == null) throw new IllegalArgumentException("The projet argument is required");
        if (statut == null) throw new IllegalArgumentException("The statut argument is required");
        EntityManager em = Livraison.entityManager();
        TypedQuery<Livraison> q = em.createQuery("SELECT o FROM Livraison AS o WHERE o.materielRma.projet = :projet AND o.materielRma.statut = :statut", Livraison.class);
        q.setParameter("projet", projet);
        q.setParameter("statut", statut);
        return q;
    }
	
}
