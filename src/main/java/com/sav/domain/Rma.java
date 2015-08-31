package com.sav.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import com.sav.domain.Client;
import javax.persistence.ManyToOne;
import com.sav.domain.AdressRetour;
import org.springframework.beans.factory.annotation.Value;
import com.sav.reference.Transport;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findRmasByRmaNumberLike" })
public class Rma {

    private transient Long rmaGenereNumber;

    @NotNull
    @Column(unique = true)
    private String rmaNumber;

    private String societe;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dateCreation;

    @NotNull
    @ManyToOne
    private Client client;

    @NotNull
    @ManyToOne
    private AdressRetour adresseDeRetour;

    @Value("NH")
    private String creeePar;

    @Enumerated
    private Transport transport;

    public static long countYearRma() {
        EntityManager em = entityManager();
        return em.createQuery("SELECT COUNT(o) FROM Rma o WHERE (YEAR(o.dateCreation) = (YEAR(sysdate())))", Long.class).getSingleResult();
    }

    public Long getRmaGenereNumber() {
        rmaGenereNumber = countYearRma() + 1;
        return rmaGenereNumber;
    }
    
    
    public String getRmaNumber() {
        if (rmaNumber == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yy");
            String rmaYear = sdf.format(Calendar.getInstance().getTime());
            NumberFormat format = NumberFormat.getInstance();
            format.setMinimumIntegerDigits(3);
            rmaNumber = "FR" + format.format(getRmaGenereNumber()) + "/" + rmaYear;
        }
        return rmaNumber;
    }

    public void setRmaNumber(String rmaNumber) {
        this.rmaNumber = rmaNumber;
    }


	public static List<Rma> findAllRmas() {
        return entityManager().createQuery("SELECT o FROM Rma o order by o.dateCreation desc", Rma.class).getResultList();
    }

	public static List<Rma> findRmaEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Rma o order by o.dateCreation desc", Rma.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
}
