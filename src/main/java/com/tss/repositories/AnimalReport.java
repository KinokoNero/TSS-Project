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
    
    public int getDietCount() {
        return dietCount;
    }

    public void setDietCount(int dietCount) {
        this.dietCount = dietCount;
    }

    /*public int getCarnivoreCount() {
        return carnivoreCount;
    }

    public void setCarnivoreCount(int carnivoreCount) {
        this.carnivoreCount = carnivoreCount;
    }

    public int getHerbivoreCount() {
        return herbivoreCount;
    }

    public void setHerbivoreCount(int herbivoreCount) {
        this.herbivoreCount = herbivoreCount;
    }

    public int getOmnivoreCount() {
        return omnivoreCount;
    }

    public void setOmnivoreCount(int omnivoreCount) {
        this.omnivoreCount = omnivoreCount;
    }*/
    
}
