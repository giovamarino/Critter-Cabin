package com.techelevator.dao;

import com.techelevator.model.Volunteer;

import java.util.List;

public interface VolunteerDao {

    List<Volunteer> getAllVolunteers();

    Volunteer getVolunteerById(int id);

    List<Volunteer> getVolunteersByStatus(String status);

    void updateStatus(int id, String approvalStatus);

    Volunteer applyToVolunteer(Volunteer volunteer);

    List <Volunteer> getVolunteerByStatusWithRole(String status);
}
