package com.example.zpi;

public class AnimalModel {

    String animalName, animalType, animalBreed, animalWeight, animalDate, animalBio;
    String url = "0.jpg";

    public AnimalModel() {

    }

    public AnimalModel(String animalName, String animalType) {
        this.animalName = animalName;
        this.animalType = animalType;
    }

    public AnimalModel(String animalName, String animalType, String animalWeight, String animalDate, String animalBio) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.animalDate = animalDate;
        this.animalBio = animalBio;
    }

    public AnimalModel(String animalName, String animalType, String animalBreed, String animalWeight, String animalDate, String animalBio) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalBreed = animalBreed;
        this.animalWeight = animalWeight;
        this.animalDate = animalDate;
        this.animalBio = animalBio;
    }



    public String getAnimalName() { return animalName; }

    public String getAnimalType() { return animalType; }

    public String getAnimalBreed() { return animalBreed; }

    public String getAnimalWeight() { return animalWeight; }

    public String getAnimalDate() { return animalDate; }

    public String getAnimalBio() { return animalBio; }
}
