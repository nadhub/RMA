package com.sav.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooEntity
public class Client {

    @NotNull
    private String client;

    @Size(max = 100)
    private String adresse1;

    @Size(max = 100)
    private String adresse2;

    private String codePostal;

    private String ville;

    private String pays;

    private String region;

    private String contact;

    private String tel;

    private String email;

	public static List<Client> findAllClients() {
        return entityManager().createQuery("SELECT o FROM Client o ORDER BY o.client asc", Client.class).getResultList();
    }

	public static List<Client> findClientEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Client o ORDER BY o.client asc", Client.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
}
