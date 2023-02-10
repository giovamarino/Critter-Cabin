package com.techelevator.dao;


import com.techelevator.model.PetImage;

import java.util.List;

public interface PetImageDao {

    List<PetImage> getAllPetImagesById(int petId);

    PetImage getPetImageById(int imageId);

    PetImage addNewPetImage(PetImage petImage);

    void setPrimaryImage(int id);

    boolean deletePetImage(int id);

    PetImage getPrimaryImage(int petId);

    PetImage addAdditional(int petId, String petImage);



}
