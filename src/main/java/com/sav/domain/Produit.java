package com.sav.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.List;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooEntity
public class Produit {

    @NotNull
    private String modele;

    private String codeArticle;

	public static List<Produit> findAllProduits() {
        return entityManager().createQuery("SELECT o FROM Produit o ORDER BY o.modele", Produit.class).getResultList();
    }
}
