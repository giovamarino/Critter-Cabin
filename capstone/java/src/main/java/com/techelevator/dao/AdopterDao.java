package com.techelevator.dao;

import com.techelevator.model.Adopter;

import java.util.List;

public interface AdopterDao {

    Adopter applyToAdopt(Adopter adopter, int id);

    List<Adopter> getAdoptionRequestsByStatus(String status);

    Adopter getAdopterById(int id);

    void updateStatus(int id, String approvalStatus);
}
