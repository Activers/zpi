package com.example.zpi;

public class AnimalModel {

    String animalName, animalType, animalBreed, animalWeight, animalDate, animalBio;

    Integer animalAvatar;

    public AnimalModel() {

    }

    public AnimalModel(String animalName, String animalType) {
        PetAvatarSwitch(animalType);
        this.animalName = animalName;
        this.animalType = animalType;
    }

    public AnimalModel(String animalName, String animalType, String animalWeight, String animalDate, String animalBio) {
        PetAvatarSwitch(animalType);
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.animalDate = animalDate;
        this.animalBio = animalBio;
    }

    public AnimalModel(String animalName, String animalType, String animalBreed, String animalWeight, String animalDate, String animalBio) {
        PetAvatarSwitch(animalType);
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

    public Integer getAnimalAvatar() { return animalAvatar; }

    public void PetAvatarSwitch(String animalType)
    {
        switch (animalType) {
            // Ssaki
            case "PIES":
                animalAvatar = R.drawable.pies2;
                break;
            case "KOT":
                animalAvatar = R.drawable.kot2;
                break;
            case "KRÓLIK":
                animalAvatar = R.drawable.krolik2;
                break;
            case "CHOMIK":
                animalAvatar = R.drawable.chomik2;
                break;
            case "SZYNSZYLA":
                animalAvatar = R.drawable.szynszyla2;
                break;
            case "SZCZUR":
                animalAvatar = R.drawable.szczur;
                break;
            case "MYSZ":
                animalAvatar = R.drawable.szczur;
                break;
            case "ŚWINKA MORSKA":
                animalAvatar = R.drawable.swinkamorska2;
                break;
            case "JEŻ":
                animalAvatar = R.drawable.jez;
                break;
            // Gady
            case "WĄŻ":
                animalAvatar = R.drawable.gady2;
                break;
            case "ŻÓŁW":
                animalAvatar = R.drawable.zolw2;
                break;
            case "JASZCZURKA":
                animalAvatar = R.drawable.gady2;
                break;
            // Ptaki
            case "PAPUGA ARA":
                animalAvatar = R.drawable.ptaki2;
                break;
            case "KANAREK":
                animalAvatar = R.drawable.ptaki2;
                break;
            // Płazy
            case "AKSOLOTL":
                animalAvatar = R.drawable.plazy2;
                break;
            // Bezkręgowce
            case "PATYCZAK":
                animalAvatar = R.drawable.bezkregowce2;
                break;
            case "MODLISZKA":
                animalAvatar = R.drawable.bezkregowce2;
                break;
            case "PAJĄK":
                animalAvatar = R.drawable.bezkregowce2;
                break;
            default:
                animalAvatar = R.drawable.ssaki2;
                break;
        }
    }

}
