package com.sav.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.format.annotation.DateTimeFormat;
import com.sav.reference.ProjectKrakRma;
import javax.persistence.Enumerated;
import com.sav.reference.Transport;
import com.sav.domain.AdressRetour;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
public class KrakRma {

    private transient Long rmaKrakGenereNumber;

    @NotNull
    private String packingList;
    
    @ManyToOne
    private AdressRetour deliverySite;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dateOfShipment;

    @Enumerated
    private ProjectKrakRma projectName;

    @Enumerated
    private Transport transport;

    private String trackingNumber;
    
       
    public static TypedQuery<KrakRma> findKrakramasById(Long id) {
        if (id == null) throw new IllegalArgumentException("The id argument is required");
        EntityManager em = entityManager();
        TypedQuery<KrakRma> q = em.createQuery("SELECT o FROM KrakRma AS o WHERE o.id = :id", KrakRma.class);
        q.setParameter("id", id);
        return q;
    }

    public static List<KrakRma> findAllKrakRmas() {
        return entityManager().createQuery("SELECT o FROM KrakRma o ORDER BY o.dateOfShipment desc", KrakRma.class).getResultList();
    }

    public static List<KrakRma> findKrakRmaEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM KrakRma o ORDER BY o.dateOfShipment desc", KrakRma.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    public static long countYearRmaKrak() {
        EntityManager em = entityManager();
        return em.createQuery("SELECT COUNT(o) FROM KrakRma o WHERE (YEAR(o.dateOfShipment) = (YEAR(sysdate())))", Long.class).getSingleResult();
    }

    public Long getRmaKrakGenereNumber() {
        rmaKrakGenereNumber = countYearRmaKrak() + 1;
        return rmaKrakGenereNumber;
    }

    public String getPackingList() {
        if (packingList == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String rmaKrakYear = sdf.format(Calendar.getInstance().getTime());
            packingList = "BLKRAK-" + rmaKrakYear + "-" + getRmaKrakGenereNumber();
        }
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }
}
