package com.tss.controllers;

import com.tss.entities.Animal;
import com.tss.repositories.AnimalRepository;
import java.util.Arrays;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/animals/json")
public class ApplicationJsonController {
    @Autowired
    AnimalRepository animalRepository;
    
    @GetMapping()
    public List<Animal> list() {
        return (List<Animal>) animalRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Animal input) {
        Animal animal = animalRepository.findById(id).get();        
        animal.setSpecies(input.getSpecies());
        animal.setName(input.getName());
        animal.setSex(input.getSex());
        animal.setAge(input.getAge());
        animal.setWeight(input.getWeight());
        animal.setDiet(input.getDiet());
        animalRepository.save(animal);
        return null;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Animal input) {
        Animal animal = new Animal();        
        animal.setSpecies(input.getSpecies());
        animal.setName(input.getName());
        animal.setSex(input.getSex());
        animal.setAge(input.getAge());
        animal.setWeight(input.getWeight());
        animal.setDiet(input.getDiet());
        animalRepository.save(animal);
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));
        
        animalRepository.delete(animal);
        return null;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {}
    
    @GetMapping("/enums")
    public ResponseEntity<Map<String, List<String>>> getEnums() {
        Map<String, List<String>> enumsMap = new HashMap<>();
        
        List<String> sexes = Arrays.stream(com.tss.entities.Animal.Sex.values())
                                    .map(Enum::name)
                                    .collect(Collectors.toList());
        enumsMap.put("sexes", sexes);
        
        List<String> diets = Arrays.stream(com.tss.entities.Animal.Diet.values())
                                   .map(Enum::name)
                                   .collect(Collectors.toList());
        enumsMap.put("diets", diets);
        
        return ResponseEntity.ok(enumsMap);
    }
}
