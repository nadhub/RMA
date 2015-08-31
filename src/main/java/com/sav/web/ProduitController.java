package com.sav.web;

import com.sav.domain.Produit;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "produits", formBackingObject = Produit.class)
@RequestMapping("/produits")
@Controller
public class ProduitController {
}
