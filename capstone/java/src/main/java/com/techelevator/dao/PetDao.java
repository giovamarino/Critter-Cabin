package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.util.List;

public interface PetDao {

    List<Pet> getAllPets();

    Pet getPetById(int petId);

    Pet addNewPet(Pet pet);

    void editPet(int id, Pet pet);
}
