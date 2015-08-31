package com.sav.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.List;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooEntity
public class Piece {

    @NotNull
    private String piece;

    private String codePiece;

    private float weight;

	public static List<Piece> findAllPieces() {
        return entityManager().createQuery("SELECT o FROM Piece o ORDER BY piece", Piece.class).getResultList();
    }
}
