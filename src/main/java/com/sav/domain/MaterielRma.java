package com.sav.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import com.sav.domain.Rma;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
import com.sav.domain.Produit;
import com.sav.reference.Projet;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Size;
import com.sav.reference.Statut;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findMaterielRmasByRma", "findMaterielRmasByStatut", "findMaterielRmasByProjetAndStatut", "findMaterielRmasByDiagnosticLike", "findMaterielRmasByDateReceptionGreaterThanEquals", "findMaterielRmasByNumSerieEntreeLikeAndModele" })
public class MaterielRma {

    @NotNull
    @ManyToOne
    private Rma rma;

    @NotNull
    @ManyToOne
    private Produit modele;

    @NotNull
    private String numSerieEntree;

    @Size(max = 300)
    private String panne;

    @Enumerated
    private Projet projet;

    private Boolean garantie;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dateReception;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dateReparation;

    @Size(max = 300)
    private String diagnostic;

    @Size(max = 300)
    private String action;

    private Boolean materielRemplace;

    private String numSerieSortie;

    private String ipSav;

    @Enumerated
    private Statut statut;

    @Size(max = 300)
    private String notes;

    public static TypedQuery<MaterielRma> findMaterielRmasSncf(Projet projet) {
        EntityManager em = entityManager();
        TypedQuery<MaterielRma> q = em.createQuery("SELECT o FROM MaterielRma AS o WHERE o.projet = :projet AND YEAR(o.dateReception)!=2010 ORDER BY o.dateReception desc", MaterielRma.class);
        q.setParameter("projet", projet);
        return q;
    }

    public static TypedQuery<MaterielRma> findMaterielRmasVisage() {
        EntityManager em = entityManager();
        TypedQuery<MaterielRma> q = em.createQuery("SELECT o FROM MaterielRma AS o WHERE o.projet = 1 AND YEAR(o.dateReception)!=2010 ORDER BY o.dateReception desc", MaterielRma.class);
        return q;
    }

    public static TypedQuery<MaterielRma> findMaterielRmasPdp() {
        EntityManager em = entityManager();
        TypedQuery<MaterielRma> q = em.createQuery("SELECT o FROM MaterielRma AS o WHERE o.projet = 2 AND YEAR(o.dateReception)!=2010 ORDER BY o.dateReception desc", MaterielRma.class);
        return q;
    }

    public static List<MaterielRma> findAllMaterielRmas() {
        return entityManager().createQuery("SELECT o FROM MaterielRma o ORDER BY o.dateReception desc", MaterielRma.class).getResultList();
    }

    public static List<MaterielRma> findMaterielRmaEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM MaterielRma o ORDER BY o.dateReception desc ", MaterielRma.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    public static TypedQuery<MaterielRma> findMaterielRmasByClient(Client client) {
        if (client == null) throw new IllegalArgumentException("This client argument is required");
        EntityManager em = MaterielRma.entityManager();
        TypedQuery<MaterielRma> q = em.createQuery("SELECT o FROM MaterielRma AS o WHERE o.rma.client = :client ORDER BY o.dateReception desc", MaterielRma.class);
        q.setParameter("client", client);
        return q;
    }

    public static TypedQuery<MaterielRma> findMaterielRmasByModele(String modele, Projet projet) {
        if (modele == null) throw new IllegalArgumentException("This model argument is required");
        EntityManager em = MaterielRma.entityManager();
        TypedQuery<MaterielRma> q = em.createQuery("SELECT o FROM MaterielRma AS o WHERE o.modele.modele = :modele AND o.projet = :projet  ORDER BY o.dateReception desc", MaterielRma.class);
        q.setParameter("modele", modele);
        q.setParameter("projet", projet);
        return q;
    }
    

	public static TypedQuery<MaterielRma> findMaterielRmasByNumSerieEntreeLikeAndModele(String numSerieEntree, Produit modele) {
       if (numSerieEntree == null || numSerieEntree.length() == 0) throw new IllegalArgumentException("The numSerieEntree argument is required");
        numSerieEntree = numSerieEntree.replace('*', '%');
       if (numSerieEntree.charAt(0) != '%') {
            numSerieEntree = "%" + numSerieEntree;
        }
        if (numSerieEntree.charAt(numSerieEntree.length() - 1) != '%') {
            numSerieEntree = numSerieEntree + "%";
        }
        if (modele == null) throw new IllegalArgumentException("The modele argument is required");
        EntityManager em = MaterielRma.entityManager();
        TypedQuery<MaterielRma> q = em.createQuery("SELECT o FROM MaterielRma AS o WHERE LOWER(o.numSerieEntree) LIKE LOWER(:numSerieEntree)  AND o.modele = :modele", MaterielRma.class);
        q.setParameter("numSerieEntree", numSerieEntree);
        q.setParameter("modele", modele);
        return q;
    }

	///////////////////////////////////////////////
	
	public static TypedQuery<MaterielRma> findMaterielRmasByNumSerieEntreeLikeAndRma(String numSerieEntree, Rma rma) {
	       if (numSerieEntree == null || numSerieEntree.length() == 0) throw new IllegalArgumentException("The numSerieEntree argument is required");
	        numSerieEntree = numSerieEntree.replace('*', '%');
	       if (numSerieEntree.charAt(0) != '%') {
	            numSerieEntree = "%" + numSerieEntree;
	        }
	        if (numSerieEntree.charAt(numSerieEntree.length() - 1) != '%') {
	            numSerieEntree = numSerieEntree + "%";
	        }
	        if (rma == null) throw new IllegalArgumentException("The RMA argument is required");
	        EntityManager em = MaterielRma.entityManager();
	        TypedQuery<MaterielRma> q = em.createQuery("SELECT o FROM MaterielRma AS o WHERE LOWER(o.numSerieEntree) LIKE LOWER(:numSerieEntree)  AND o.rma = :rma", MaterielRma.class);
	        q.setParameter("numSerieEntree", numSerieEntree);
	        q.setParameter("rma", rma);
	        return q;
	    }
	
	public static TypedQuery<MaterielRma> findMaterielRmasByNumSerieEntreeLikeAndRmaBis(String numSerieEntree, Rma rma) {
	      
	        EntityManager em = MaterielRma.entityManager();
	        TypedQuery<MaterielRma> q = em.createQuery("SELECT o FROM MaterielRma AS o WHERE LOWER(o.numSerieEntree) = LOWER(:numSerieEntree)  AND o.rma = :rma", MaterielRma.class);
	        q.setParameter("numSerieEntree", numSerieEntree);
	        q.setParameter("rma", rma);
	        return q;
	    }
	
	
	public static TypedQuery<MaterielRma> findMaterielRmasByStatut(Statut statut) {
        if (statut == null) throw new IllegalArgumentException("The statut argument is required");
        EntityManager em = MaterielRma.entityManager();
        TypedQuery<MaterielRma> q = em.createQuery("SELECT o FROM MaterielRma AS o WHERE o.statut = :statut ORDER BY o.dateReception asc", MaterielRma.class);
        q.setParameter("statut", statut);
        return q;
    }
}
