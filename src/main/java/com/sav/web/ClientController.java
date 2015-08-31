package com.sav.web;

import com.sav.domain.Client;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "clients", formBackingObject = Client.class)
@RequestMapping("/clients")
@Controller
public class ClientController {
}
