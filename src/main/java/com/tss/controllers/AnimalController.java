package com.tss.controllers;

import com.tss.components.SessionComponent;
import com.tss.entities.Animal;
import com.tss.repositories.AnimalRepository;
import com.tss.repositories.IAnimalReport;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnimalController {
    private final AnimalRepository animalRepository;
    
    @Autowired
    SessionComponent sessionComponent;
    
    @Autowired
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
    
    @RequestMapping("/animals")
    public String showAnimalList(Model model) {
        model.addAttribute("animals", animalRepository.findAll());   
        
        List<IAnimalReport> animalsDietStats = animalRepository.getAnimalsDietStats();
        model.addAttribute("animalsDietStats", animalsDietStats);
        model.addAttribute("counterValue", sessionComponent.getCounter());
        
        return "animals.html";
    }
    
    @GetMapping("/showAddAnimalForm")
    public String showAddForm(Animal animal) {
        return "addAnimalForm";
    }
    @PostMapping("/addAnimal")
    public String addAnimal(Animal animal, BindingResult result, Model model) {
        if(result.hasErrors())
            return "addAnimalForm";
        
        animalRepository.save(animal);
        sessionComponent.increaseCounter();
        return "redirect:/animals";
    }
    
    @GetMapping("/showEditAnimalForm/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid animal Id: " + id));
        
        model.addAttribute("animal", animal);
        return "editAnimalForm";
    }
    @PostMapping("/editAnimal/{id}")
    public String editAnimal(@PathVariable("id") long id, Animal animal, BindingResult result, Model model) {
        if(result.hasErrors()) {
            animal.setId(id);
            return "editAnimalForm";
        }   
        
        animalRepository.save(animal);
        sessionComponent.increaseCounter();
        return "redirect:/animals";
    }
    
    @GetMapping("/deleteAnimal/{id}")
    public String deleteAnimal(@PathVariable("id") long id, Model model) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid animal Id: " + id));
        
        animalRepository.delete(animal);
        sessionComponent.increaseCounter();
        return "redirect:/animals";
    }
}
