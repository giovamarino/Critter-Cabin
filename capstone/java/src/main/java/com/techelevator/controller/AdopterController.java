package com.techelevator.controller;

import com.techelevator.dao.AdopterDao;
import com.techelevator.dao.PetDao;
import com.techelevator.model.Adopter;
import com.techelevator.model.GMailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class AdopterController {
    @Autowired
    private AdopterDao adopterDao;

    @Autowired
    private PetDao petDao;

    //person can request adopt -> brought to page for that pet -> request gets put in table -> admin can view table and approve/deny request

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/pets/{id}/adopt")
    public Adopter applyToAdopt(@Valid @RequestBody Adopter adopter, @PathVariable int id){
        Adopter newAdoptionApplication = adopterDao.applyToAdopt(adopter, id);
        return newAdoptionApplication;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/adoption_applications")
    public List<Adopter> getPendingAdoptionApplications(){
        return adopterDao.getAdoptionRequestsByStatus("Pending");
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PutMapping(path = "/adoption_applications/{id}")
//    public void approveDenyApplication(@PathVariable int id, @RequestBody Adopter application) throws Exception {
//        Adopter adopter = adopterDao.getAdopterById(id);
//
//        //TODO: automated message for when adoption accepted/denied?
//
//        String email = adopter.getEmail();
//        GMailer sendEmail = new GMailer();
//
//        if(application.getApprovalStatus().equals("Approved")){
//            adopterDao.updateStatus(id, "Approved");
//            petDao.editPet(id, pet);
//        }
//    }
}
