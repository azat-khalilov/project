package com.company.applicationforcbrf.controllers;

import com.company.applicationforcbrf.service.ContentFileService;
import com.company.applicationforcbrf.service.DataFileService;
import com.company.applicationforcbrf.xtable.Xtable;
import com.company.applicationforcbrf.xtable.XtableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class XtableController {
    private final XtableService xtableService;
    private final ContentFileService contentFileService;
    private final DataFileService dataFileService;


    public XtableController(XtableService xtableService, ContentFileService contentFileService, DataFileService dataFileService) {
        this.xtableService = xtableService;
        this.contentFileService = contentFileService;
        this.dataFileService = dataFileService;
    }


    @GetMapping(value = "/index")
    public String index(Model model) {
        List<Xtable> table = xtableService.getFromTable();
        Xtable xtable = new Xtable();
        MultipartFile file = null;
        model.addAttribute("table", table);
        model.addAttribute("xtable", xtable);
        model.addAttribute("file", file);
        return "index";
    }

    @PostMapping(value = "/add")
    public String postFile(@ModelAttribute MultipartFile file, @ModelAttribute Xtable xtable,
                           Model model) {
        List<Xtable> table = xtableService.getFromTable();
        model.addAttribute("table", table);
        contentFileService.write(file);
        dataFileService.write(xtable.toString());
        return "index";
    }

    @PostMapping(value = "/upload")
    public String upload(@ModelAttribute MultipartFile file, @ModelAttribute Xtable xtable,
                         Model model) {
        xtableService.addToTable();
        List<Xtable> table = xtableService.getFromTable();
        model.addAttribute("file", file);
        model.addAttribute("xtable", xtable);
        model.addAttribute("table", table);
        return "index";
    }
}
