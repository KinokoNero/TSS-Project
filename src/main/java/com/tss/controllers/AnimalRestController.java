package com.tss.controllers;

import com.tss.components.SessionComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnimalRestController {
    @Autowired
    SessionComponent sessionComponent;
    
    @PostMapping("/sessionCounter")
    public void increaseSessionCounter() {
        sessionComponent.increaseCounter();
    }
    
    @RequestMapping("/animals/rest")
    public String showAnimalListRest(Model model) {        
        return "animalsRest.html";
    }
}
