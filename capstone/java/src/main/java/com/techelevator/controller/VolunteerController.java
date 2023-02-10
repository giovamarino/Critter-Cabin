package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.GMailer;
import com.techelevator.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/volunteer")
@RestController
@CrossOrigin
public class VolunteerController {

    @Autowired
    private VolunteerDao volunteerDao;

    @Autowired
    private UserDao userDao;

//    @GetMapping(path = "/directory")
//    public List<Volunteer> getAllVolunteers(){
//        return volunteerDao.getAllVolunteers();
//    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    //Admin has permission to approve applications
    @GetMapping(path = "/directory")
    public List<Volunteer> getAllApprovedVolunteers(){
        return volunteerDao.getVolunteerByStatusWithRole("Approved");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    //Admin has permission to approve applications
    @GetMapping(path = "/applications")
    public List<Volunteer> getAllPendingVolunteers(){
        return volunteerDao.getVolunteersByStatus("Pending");
    }

    // Where to get hasRole name
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public void approveDenyApplication(@PathVariable int id, @RequestBody Volunteer application) throws Exception {
        Volunteer volunteer = volunteerDao.getVolunteerById(id);
        String email = volunteer.getEmail();
        GMailer sendEmail = new GMailer();
            if (application.getStatus().equals("Approved")) {
                String password = getRandomPassword();
                String username = volunteer.getVolunteerFirstName() + "." + volunteer.getVolunteerLastName();
                volunteerDao.updateStatus(id, "Approved");
                userDao.createWithAppId(username, password, "ROLE_USER", application.getApplicationId());
//                userDao.updateApplicationId(id);
                sendEmail.sendMail(email, "Welcome to the team!",
                        "Dear " + volunteer.getVolunteerFirstName() + " you have been approved to start working on our team at the Critter Cabin!" +
                                "\n\n\nHere are your login credentials:\nUsername: " + username + "\nPassword: " + password + "\n You will be prompted to change your password upon the first time signing in.");
            } else {
                volunteerDao.updateStatus(id, "Denied");
                sendEmail.sendMail(email, "Critter Cabin information",
                        "Thank you for applying to volunteer at Critter Cabin. Unfortunately at this time we are not in need of additional volunteers. " +
                                "Feel free to apply again in the future.");
            }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/apply")
    public Volunteer applyToVolunteer(@Valid @RequestBody Volunteer volunteer){
        Volunteer newApplication = volunteerDao.applyToVolunteer(volunteer);
        return newApplication;
    }

    static String getRandomPassword() {
        int lengthOfPassword = 14;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder randomPassword = new StringBuilder(lengthOfPassword);
        for (int i = 0; i < lengthOfPassword; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            randomPassword.append(AlphaNumericString.charAt(index));
        }
        return randomPassword.toString();
    }





}
