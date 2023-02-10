package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private VolunteerDao volunteerDao;

    @Autowired
    private UserDao userDao;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping (path = "directory/{applicationId}")
    public void promoteToAdmin(@PathVariable int applicationId){
        userDao.updateRole(applicationId, "ROLE_ADMIN");
    }



//
//        @RequestMapping(path = "/volunteer/directory", method= RequestMethod.GET)
//        public User getUserByApplicationId(@PathVariable int applicationId){
//        User user = userDao.getUserByApplicationId(applicationId);
//            if (user == null) {
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found", null);
//            } else
//                return userDao.getUserByApplicationId(applicationId);
//        }
//    }

    }

