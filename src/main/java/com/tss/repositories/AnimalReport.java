package com.tss.repositories;

public class AnimalReport {    
    private String animalDiet = "";
    private int dietCount = 0;
    //private int carnivoreCount = 0;
    //private int herbivoreCount = 0;
    //private int omnivoreCount = 0;
    
    public AnimalReport(String animalDiet, int dietCount) {
        this.animalDiet = animalDiet;
        this.dietCount = dietCount;
    }

    public String getAnimalDiet() {
        return animalDiet;
    }

    public void setAnimalDiet(String animalDiet) {
        this.animalDiet = animalDiet;
    }
    
    public long getDietCount() {
        return dietCount;
    }

    public void setDietCount(int dietCount) {
        this.dietCount = dietCount;
    }
    
}
