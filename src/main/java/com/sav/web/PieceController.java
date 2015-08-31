package com.sav.web;

import com.sav.domain.Piece;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "pieces", formBackingObject = Piece.class)
@RequestMapping("/pieces")
@Controller
public class PieceController {
}
