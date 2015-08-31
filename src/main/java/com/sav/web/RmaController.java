package com.sav.web;

import com.sav.domain.Rma;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "rmas", formBackingObject = Rma.class)
@RequestMapping("/rmas")
@Controller
public class RmaController {
}
