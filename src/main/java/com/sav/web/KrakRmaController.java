package com.sav.web;

import com.sav.domain.KrakRma;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "krakrmas", formBackingObject = KrakRma.class)
@RequestMapping("/krakrmas")
@Controller
public class KrakRmaController {
	
	@RequestMapping(value = "/krakrmasDetails/{id}/{format}", method = RequestMethod.GET)
    public String generateBorederaudelivraison(@PathVariable("format") String format, Model uiModel, @PathVariable("id") Long id ) {
 		
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(com.sav.domain.KrakRma.findKrakramasById(id).getResultList(),false);
        JRBeanCollectionDataSource subdataSource = new JRBeanCollectionDataSource(com.sav.domain.PieceOff.findPieceOffsReport().getResultList(),false);
        JRBeanCollectionDataSource subdataSource2 = new JRBeanCollectionDataSource(com.sav.domain.PieceOff.findPieceOffBoxsById(id).getResultList(),false);

        uiModel.addAttribute("format", format);
        uiModel.addAttribute("bordereaupackingList", dataSource);
        uiModel.addAttribute("JasperCustomSubReportDatasource", subdataSource);
        uiModel.addAttribute("JasperCustomSubReportDatasource2", subdataSource);

        return "krakrma_bordereaupacking";

    }
	
}
