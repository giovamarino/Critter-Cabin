package com.techelevator.controller;

import com.techelevator.dao.PetImageDao;
import com.techelevator.model.Pet;
import com.techelevator.model.PetImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RequestMapping(path = "/petImage")
@RestController
public class PetImageController {

    @Autowired
    private PetImageDao petImageDao;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public List<PetImage> getAllPetImages(@Valid @PathVariable int id) {
        return petImageDao.getAllPetImagesById(id);
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add/{id}")
    public PetImage addMultiplePhotos(@PathVariable int id, @RequestBody PetImage petImage){
        System.out.println(petImage);
        return petImageDao.addAdditional(id, petImage.getPetImage());
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/primary")
    public void setPrimaryImage(@PathVariable int id){
        petImageDao.setPrimaryImage(id);
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/delete")
    public void deletePetImage(@RequestBody PetImage petImage){
        boolean deleted = petImageDao.deletePetImage(petImage.getPetImageId());
        if(!deleted){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
