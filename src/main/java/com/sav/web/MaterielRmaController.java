package com.sav.web;

import com.sav.domain.Client;
import com.sav.domain.MaterielRma;
import com.sav.domain.Produit;
import com.sav.domain.Rma;
import com.sav.reference.Projet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.gvnix.web.report.roo.addon.GvNIXReports;
import org.hamcrest.core.IsNull;

@RooWebScaffold(path = "materielrmas", formBackingObject = MaterielRma.class)
@RequestMapping("/materielrmas")
@Controller
@GvNIXReports({ "equipement|pdf", "visage|pdf", "pdp|pdf", "model|pdf,xls" })
public class MaterielRmaController {

///////////////////////////////////// TN REPORT //////////////////////////////////////////////////	
    @RequestMapping(value = "/reports/equipement", params = "form", method = RequestMethod.GET)
    public String generateEquipementForm(Model uiModel) {
        String[] reportFormats = { "pdf", "xls" };
        Collection<String> reportFormatsList = Arrays.asList(reportFormats);
        uiModel.addAttribute("report_formats", reportFormatsList);
        return "materielrmas/equipement";
    }

    @RequestMapping(value = "/reports/equipement", method = RequestMethod.GET)
    public String generateEquipement(@RequestParam("format") String format, @RequestParam Projet projet, Model uiModel) {
        if (null == format || format.length() <= 0) {
            uiModel.addAttribute("error", "message_format_required");
            return "materielrmas/equipement";
        }
        final String REGEX = "(pdf|xls)";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(format);
        if (!matcher.matches()) {
            uiModel.addAttribute("error", "message_format_invalid");
            return "materielrmas/equipement";
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(com.sav.domain.MaterielRma.findMaterielRmasSncf(projet).getResultList(), false);
        uiModel.addAttribute("format", format);
        uiModel.addAttribute("projet", projet);
        uiModel.addAttribute("title", "EQUIPEMENT");
        uiModel.addAttribute("equipementList", dataSource);
        return "materielrma_equipement";
    }
////////////////////////////////////////// PDP REPORT ///////////////////////////////////////////////////////////
    @RequestMapping(value = "/reports/pdp", params = "form", method = RequestMethod.GET)
    public String generatePdpForm(Model uiModel) {
        String[] reportFormats = { "pdf" };
        Collection<String> reportFormatsList = Arrays.asList(reportFormats);
        uiModel.addAttribute("report_formats", reportFormatsList);
        return "materielrmas/pdp";
    }

    @RequestMapping(value = "/reports/pdp/{format}", method = RequestMethod.GET)
    public String generatePdp(@PathVariable("format") String format, Model uiModel) {
        if (null == format || format.length() <= 0) {
            uiModel.addAttribute("error", "message_format_required");
            return "materielrmas/pdp";
        }
        final String REGEX = "(pdf)";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(format);
        if (!matcher.matches()) {
            uiModel.addAttribute("error", "message_format_invalid");
            return "materielrmas/pdp";
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(com.sav.domain.MaterielRma.findMaterielRmasPdp().getResultList(), false);
        uiModel.addAttribute("format", format);
        uiModel.addAttribute("title", "PDP");
        uiModel.addAttribute("pdpList", dataSource);
        return "materielrma_pdp";
    }
///////////////////////////////////// VISAGE REPORT /////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/reports/visage", params = "form", method = RequestMethod.GET)
    public String generateVisageForm(Model uiModel) {
        String[] reportFormats = { "pdf" };
        Collection<String> reportFormatsList = Arrays.asList(reportFormats);
        uiModel.addAttribute("report_formats", reportFormatsList);
        return "materielrmas/visage";
    }

    @RequestMapping(value = "/reports/visage/{format}", method = RequestMethod.GET)
    public String generateVisage(@PathVariable("format") String format, Model uiModel) {
        if (null == format || format.length() <= 0) {
            uiModel.addAttribute("error", "message_format_required");
            return "materielrmas/visage";
        }
        final String REGEX = "(pdf)";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(format);
        if (!matcher.matches()) {
            uiModel.addAttribute("error", "message_format_invalid");
            return "materielrmas/visage";
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(com.sav.domain.MaterielRma.findMaterielRmasVisage().getResultList(), false);
        uiModel.addAttribute("format", format);
        uiModel.addAttribute("title", "VISAGE");
        uiModel.addAttribute("visageList", dataSource);
        return "materielrma_visage";
    }

/////////////////////////////// REPORT BY MODEL ////////////////////////////////////////////////////
    
    @RequestMapping(value = "/reports/model", params = "form", method = RequestMethod.GET)
    public String generateModelForm(Model uiModel) {
    	String[] reportFormats =  {"pdf","xls"};
    	Collection<String> reportFormatsList = Arrays.asList(reportFormats);
    	uiModel.addAttribute("report_formats", reportFormatsList);
    	//uiModel.addAttribute("Produit", MaterielRma.findAllMaterielRmas());
    	return "materielrmas/model";
    }

    @RequestMapping(value = "/reports/model", method = RequestMethod.GET)
    public String generateModel(@RequestParam(value = "format", required = true) String format, @RequestParam(value = "modele") String modele, @RequestParam(value ="projet") Projet projet, Model uiModel) {
    	if ( null == format || format.length() <= 0 ) {
    		uiModel.addAttribute("error", "message_format_required");
    		return "materielrmas/model";
    	}
    	final String REGEX = "(pdf|xls)";
    	Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
    	Matcher matcher = pattern.matcher(format);
    	if ( !matcher.matches() ) {
    		uiModel.addAttribute("error", "message_format_invalid");
    		return "materielrmas/model";
    	}
    	JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(com.sav.domain.MaterielRma.findMaterielRmasByModele(modele, projet).getResultList(), false);
    	
    	uiModel.addAttribute("format", format);
    	uiModel.addAttribute("modele", modele);
    	uiModel.addAttribute("projet", projet);
    	uiModel.addAttribute("modelList", dataSource);
    	return "materielrma_model";
    }
    
    ///////////////////////////////////// FINDER BY CLIENT //////////////////////////////////////////    
    @RequestMapping(params = { "find=ByClient", "form" }, method = RequestMethod.GET)
    public String findMaterielRmasByClientForm(Model uiModel) {
        uiModel.addAttribute("clients", Client.findAllClients());
        return "materielrmas/findMaterielRmasByClient";
    }

    @RequestMapping(params = "find=ByClient", method = RequestMethod.GET)
    public String findMaterielRmaByClient(@RequestParam("client") Client client, Model uiModel) {
        uiModel.addAttribute("materielrmas", MaterielRma.findMaterielRmasByClient(client).getResultList());
        return "materielrmas/list";
    }

    @RequestMapping(params = { "find=ByNumSerieEntreeLikeAndModele", "form" }, method = RequestMethod.GET)
    public String findMaterielRmasByNumSerieEntreeLikeAndModeleForm(Model uiModel) {
        uiModel.addAttribute("produits", Produit.findAllProduits());
        return "materielrmas/findMaterielRmasByNumSerieEntreeLikeAndModele";
    }

    @RequestMapping(params = "find=ByNumSerieEntreeLikeAndModele", method = RequestMethod.GET)
    public String findMaterielRmasByNumSerieEntreeLikeAndModele(@RequestParam("numSerieEntree") String numSerieEntree, @RequestParam("modele") Produit modele, Model uiModel) {
        uiModel.addAttribute("materielrmas", MaterielRma.findMaterielRmasByNumSerieEntreeLikeAndModele(numSerieEntree, modele).getResultList());
        return "materielrmas/list";
    }

    ////////////////////////////////
   

	@RequestMapping(method = RequestMethod.POST)
    public String create(@Valid MaterielRma materielRma, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        
    	
    	if (bindingResult.hasErrors()) {
            uiModel.addAttribute("materielRma", materielRma);
            addDateTimeFormatPatterns(uiModel);
            
            return "materielrmas/create";
        } 
    	
        if (MaterielRma.findMaterielRmasByNumSerieEntreeLikeAndRmaBis(materielRma.getNumSerieEntree(), materielRma.getRma()).getResultList().isEmpty() ){ 		
        
        uiModel.asMap().clear();
        materielRma.persist();
        return "redirect:/materielrmas/" + encodeUrlPathSegment(materielRma.getId().toString(), httpServletRequest);
        }
        else 
        {
        	return "materielrmas/rmaExiste";
        }
    }

	@RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        uiModel.addAttribute("materielRma", new MaterielRma());
        addDateTimeFormatPatterns(uiModel);
        List dependencies = new ArrayList();
        if (Rma.countRmas() == 0) {
            dependencies.add(new String[]{"rma", "rmas"});
        }
        if (Produit.countProduits() == 0) {
            dependencies.add(new String[]{"produit", "produits"});
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "materielrmas/create";
    }
	
	public String RmaExist(){
		return "materielrmas/rmaExiste";
	}
}
