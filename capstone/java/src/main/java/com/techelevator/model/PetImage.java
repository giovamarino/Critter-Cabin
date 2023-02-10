package com.techelevator.model;

public class PetImage {
    private int petImageId;
    private String petImage;
    private boolean isPrimary=false;
    private int petId;


    public int getPetImageId() {
        return petImageId;
    }

    public void setPetImageId(int petImageId) {
        this.petImageId = petImageId;
    }

    public String getPetImage() {
        return petImage;
    }

    public void setPetImage(String petImage) {
        this.petImage = petImage;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    @Override
    public String toString() {
        return "PetImage{" +
                "petImageId=" + petImageId +
                ", petImage='" + petImage + '\'' +
                ", isPrimary=" + isPrimary +
                ", petId=" + petId +
                '}';
    }
}
