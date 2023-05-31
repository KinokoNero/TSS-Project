package com.tss.controllers;

import com.tss.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnimalController {
    private final AnimalRepository animalRepository;
    
    @Autowired
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
    
    @RequestMapping("/animals")
    public String showAnimalList(Model model) {
        model.addAttribute("animals", animalRepository.findAll());        
        model.addAttribute("animalsDietStats", animalRepository.getAnimalsDietStats());
        return "animals.html";
    }
    
}
