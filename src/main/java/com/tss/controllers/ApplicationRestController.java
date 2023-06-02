package com.tss.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationRestController {
    
    @RequestMapping("/animals/rest")
    public String page(Model model) {
        return "animalsRest.html";
    }
    
}
