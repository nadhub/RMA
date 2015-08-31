package com.sav.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findAdressRetoursByAdresseRetourLike" })
public class AdressRetour {

    @NotNull
    private String adresseRetour;

    @Size(max = 100)
    private String adresse1;

    @Size(max = 100)
    private String adresse2;

    private String codePostal;

    private String ville;

    private String Pays;

    private String region;

    private String contact;

    private String tel;

    private String email;

    public static List<AdressRetour> findAllAdressRetours() {
        return entityManager().createQuery("SELECT o FROM AdressRetour o ORDER BY o.adresseRetour asc", AdressRetour.class).getResultList();
    }

    public static List<AdressRetour> findAdressRetourEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM AdressRetour o ORDER BY o.adresseRetour asc", AdressRetour.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
}
