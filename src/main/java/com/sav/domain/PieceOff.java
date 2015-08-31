package com.sav.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.format.annotation.DateTimeFormat;
import com.sav.domain.Piece;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import com.sav.domain.KrakRma;
import com.sav.reference.StatutKrak;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findPieceOffsByPackingList" })
public class PieceOff {

    @ManyToOne
    private KrakRma packingList;

    private Integer box;

    @NotNull
    @ManyToOne
    private Piece piece;

    @Size(max = 600)
    private String numSerie;

    @Size(max = 400)
    private String failureDescription;

    private Integer quantity;

    @Enumerated
    private StatutKrak statut;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dateOfreceived;

    public static TypedQuery<PieceOff> findPieceOffsReport() {
        EntityManager em = entityManager();
        TypedQuery<PieceOff> q = em.createQuery("SELECT o FROM PieceOff AS o ORDER BY o.box asc", PieceOff.class);
        return q;
    }

    public static TypedQuery<Integer> findPieceOffBoxsById(Long id) {
        if (id == null) throw new IllegalArgumentException("The id argument is required");
        EntityManager em = entityManager();
        TypedQuery<Integer> q = em.createQuery("SELECT o.box FROM PieceOff AS o WHERE o.box = (SELECT Max(o.box) FROM PieceOff as o)", Integer.class);
        return q;
    }
}
