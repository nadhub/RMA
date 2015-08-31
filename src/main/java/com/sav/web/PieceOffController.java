package com.sav.web;

import com.sav.domain.PieceOff;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.gvnix.web.report.roo.addon.GvNIXReports;

@RooWebScaffold(path = "pieceoffs", formBackingObject = PieceOff.class)
@RequestMapping("/pieceoffs")
@Controller
@GvNIXReports({ "pieceoff|pdf" })
public class PieceOffController {

	@RequestMapping(value = "/reports/pieceoff", params = "form", method = RequestMethod.GET)
    public String generatePieceoffForm(Model uiModel) {
        String[] reportFormats =  {"pdf"};
        Collection<String> reportFormatsList = Arrays.asList(reportFormats);
        uiModel.addAttribute("report_formats", reportFormatsList);
        return "pieceoffs/pieceoff";
    }

	@RequestMapping(value = "/reports/pieceoff", method = RequestMethod.GET)
    public String generatePieceoff(@RequestParam(value = "format", required = true) String format, Model uiModel) {
        if ( null == format || format.length() <= 0 ) {
                uiModel.addAttribute("error", "message_format_required");
                return "pieceoffs/pieceoff";
        }
        final String REGEX = "(pdf)";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(format);
        if ( !matcher.matches() ) {
                uiModel.addAttribute("error", "message_format_invalid");
                return "pieceoffs/pieceoff";
        }
       //Collection<PieceOff> dataSource = PieceOff.findPieceOffEntries(0, 10);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(com.sav.domain.PieceOff.findPieceOffsReport().getResultList(), false);
       
        uiModel.addAttribute("format", format);
        uiModel.addAttribute("title", "PIECEOFF");
        uiModel.addAttribute("pieceoffList", dataSource);
        uiModel.addAttribute("JasperCustomSubReportDatasource", dataSource);
        return "pieceoff_pieceoff";
    }
}
