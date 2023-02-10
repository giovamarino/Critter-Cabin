package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.PetImageDao;
import com.techelevator.model.Pet;
import com.techelevator.model.PetImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RequestMapping(path = "/pets")
@RestController
public class PetController {

    @Autowired
    private PetDao petDAO;

    @Autowired
    private PetImageDao petImageDao;

    @GetMapping()
    public List<Pet> getAllPets(){
        return petDAO.getAllPets();
    }

    @GetMapping(path = "/{petId}")
    public Pet getPetById(@PathVariable int petId){
        return petDAO.getPetById(petId);
    }

    // add/edit pet here not in volunteer controller
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping(path = "/add")
    public Pet addNewPet(@Valid @RequestBody Pet pet){
        Pet newPet = petDAO.addNewPet(pet);
        PetImage image = new PetImage();
        image.setPetImage(newPet.getPetImage());
        image.setPetId(newPet.getPetId());
        image.setPrimary(true);
        petImageDao.addNewPetImage(image);
        return newPet;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PutMapping(path = "/{id}/edit")
    public void editPet(@PathVariable int id, @RequestBody Pet pet){
        petDAO.editPet(id, pet);

    }
}
