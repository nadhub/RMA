package com.sav.web;

import com.sav.domain.AdressRetour;
import com.sav.domain.Livraison;
import com.sav.domain.MaterielRma;
import com.sav.reference.Projet;
import com.sav.reference.Statut;


import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RooWebScaffold(path = "livraisons", formBackingObject = Livraison.class)
@RequestMapping("/livraisons")
@Controller

public class LivraisonController {

	
/////////////////////////////////////// REPORT LIVRAISON ////////////////////////////////////////
	
	@RequestMapping(value = "/livraisonsDetails/{id}/{format}", method = RequestMethod.GET)
    public String generateBorederaudelivraison(@PathVariable("format") String format, Model uiModel, @PathVariable("id") Long id ) {
 		
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(com.sav.domain.Livraison.findLivraisonsById(id).getResultList(),false);
       
        uiModel.addAttribute("format", format);
        //uiModel.addAttribute("title", "BOREDERAUDELIVRAISON");
        uiModel.addAttribute("borederaudelivraisonList", dataSource);
        //return "livraison_borederaudelivraison";
        return "livraison_borederaudelivraison";

    }
///////////////////////////////////////////FINDER BY ADRESSE RETOUR  ///////////////////////////////////////////////
	
	@RequestMapping(params = { "find=ByAdressRetour", "form" }, method = RequestMethod.GET)
    public String findLivraisonsByAdressRetourForm(Model uiModel) {
        uiModel.addAttribute("adressRetours", AdressRetour.findAllAdressRetours());
        return "livraisons/findLivraisonsByAdressRetour";
    }

	@RequestMapping(params = "find=ByAdressRetour", method = RequestMethod.GET)
    public String findLivraisonsByClient(@RequestParam("adressRetour") AdressRetour adressRetour, Model uiModel) {
        uiModel.addAttribute("livraisons", Livraison.findLivraisonsByAdressRetour(adressRetour).getResultList());
        return "livraisons/list";
    }
	
	////////////////////////////////////////// FINDER BY PROJET AND STATUT ///////////////////////////
	
	@RequestMapping(params = { "find=ByProjetAndStatut", "form" }, method = RequestMethod.GET)
    public String findLivraisonsByProjetAndStatutForm(Model uiModel) {
        uiModel.addAttribute("projets", java.util.Arrays.asList(Projet.class.getEnumConstants()));
        uiModel.addAttribute("statuts", java.util.Arrays.asList(Statut.class.getEnumConstants()));
        return "livraisons/findLivraisonsByProjetAndStatut";
    }
    
    @RequestMapping(params = "find=ByProjetAndStatut", method = RequestMethod.GET)
    public String findLivraisonsByProjetAndStatut(@RequestParam("projet") Projet projet, @RequestParam("statut") Statut statut, Model uiModel) {
        uiModel.addAttribute("livraisons", Livraison.findLivraisonsByProjetAndStatut(projet, statut).getResultList());
        return "livraisons/list";
    }
	
}
