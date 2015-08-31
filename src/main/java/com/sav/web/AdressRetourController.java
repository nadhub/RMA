package com.sav.web;

import com.sav.domain.AdressRetour;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "adressretours", formBackingObject = AdressRetour.class)
@RequestMapping("/adressretours")
@Controller
public class AdressRetourController {
}
