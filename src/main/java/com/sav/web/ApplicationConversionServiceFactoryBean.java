package com.sav.web;

import com.sav.domain.AdressRetour;
import com.sav.domain.Client;
import com.sav.domain.KrakRma;
import com.sav.domain.Livraison;
import com.sav.domain.MaterielRma;
import com.sav.domain.Piece;
import com.sav.domain.PieceOff;
import com.sav.domain.Produit;
import com.sav.domain.Rma;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.RooConversionService;

/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}

	public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(new AdressRetourConverter());
        registry.addConverter(new ClientConverter());
        registry.addConverter(new LivraisonConverter());
        registry.addConverter(new MaterielRmaConverter());
        registry.addConverter(new PieceConverter());
        registry.addConverter(new PieceOffConverter());
        registry.addConverter(new ProduitConverter());
        registry.addConverter(new RmaConverter());
        registry.addConverter(new KrakRmaConverter());

    }

	public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }

	static class AdressRetourConverter implements Converter<AdressRetour, String> {
        public String convert(AdressRetour adressRetour) {
            return new StringBuilder().append(adressRetour.getAdresseRetour()).append(" ").append(adressRetour.getCodePostal()).append(" ").toString();
        }
        
    }

	static class ClientConverter implements Converter<Client, String> {
        public String convert(Client client) {
            return new StringBuilder().append(client.getClient()).append(" ").append(client.getCodePostal()).toString();
        }
        
    }


	static class LivraisonConverter implements Converter<Livraison, String> {
        public String convert(Livraison livraison) {
            return new StringBuilder().append(livraison.getReference()).append(" Date de livraison: ").append(livraison.getDateLivraison()).append(" ").toString();
        }
        
    }

	static class MaterielRmaConverter implements Converter<MaterielRma, String> {
        public String convert(MaterielRma materielRma) {
            return new StringBuilder().append(materielRma.getModele().getModele()).append(" ").append(" N°série:").append(materielRma.getNumSerieEntree()).append(" ").append(" RMA:").append(materielRma.getRma().getRmaNumber()).toString();
        }
        
    }

	static class PieceConverter implements Converter<Piece, String> {
        public String convert(Piece piece) {
            return new StringBuilder().append(piece.getPiece()).toString();
        }
        
    }

	static class PieceOffConverter implements Converter<PieceOff, String> {
        public String convert(PieceOff pieceOff) {
            return new StringBuilder().append(pieceOff.getPiece().getPiece()).append(" ").append(" N°serie:").append(pieceOff.getNumSerie()).toString();
        }
        
    }

	static class ProduitConverter implements Converter<Produit, String> {
        public String convert(Produit produit) {
            return new StringBuilder().append(produit.getModele()).toString();
        }
        
    }

	static class RmaConverter implements Converter<Rma, String> {
        public String convert(Rma rma) {
            return new StringBuilder().append(rma.getRmaNumber()).toString();
        }
   
    }

	static class KrakRmaConverter implements Converter<KrakRma, String> {
        public String convert(KrakRma krakRma) {
            return new StringBuilder().append(krakRma.getPackingList()).append(" ==>").append(krakRma.getProjectName()).toString();
        }
        
    }
}
