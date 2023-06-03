package com.tss.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnimalRestController {
    
    @RequestMapping("/animals/rest")
    public String showAnimalListRest(Model model) {        
        return "animalsRest.html";
    }
}
