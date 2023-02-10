package com.techelevator.dao;

import com.techelevator.model.Adopter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAdopterDao implements AdopterDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcAdopterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Adopter applyToAdopt(Adopter adopter, int id) {
        String sql = "insert into adopter (adopter_name, email, phone_number, city, state, zipcode, any_pets, number_pets, status) values (?,?,?,?,?,?,?,?,?) returning adopter_id";

        Integer adopterId;

        adopterId = jdbcTemplate.queryForObject(sql, Integer.class, adopter.getAdopterName(), adopter.getEmail(), adopter.getPhoneNumber(), adopter.getCity(), adopter.getState(), adopter.getZipcode(), adopter.isHasCurrentPets(), adopter.getNumberOfCurrentPets(), adopter.getApprovalStatus());

        sql = "update pets set adopter_id = ? where pet_id =?";
        jdbcTemplate.update(sql, adopterId, id);

        return getAdopterById(adopterId);
    }

    @Override
    public List<Adopter> getAdoptionRequestsByStatus(String status) {
        List<Adopter> adopterList = new ArrayList<>();
        String sql = "select adopter.adopter_id, adopter_name, email, phone_number, city, state, zipcode, any_pets, number_pets, status from adopter " +
                "join pets on pets.adopter_id = adopter.adopter_id " +
                "where status = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, status);

        while(results.next()){
            adopterList.add(mapRowToAdopter(results));
        }
        return adopterList;
    }

    @Override
    public Adopter getAdopterById(int id) {
        Adopter adopter = null;
        String sql = "select adopter_id, adopter_name, email, phone_number, city, state, zipcode, any_pets, number_pets, status from adopter where adopter_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            adopter = mapRowToAdopter(results);
        }
        return adopter;
    }

    @Override
    public void updateStatus(int id, String approvalStatus) {
        String sql = "UPDATE adopter SET status = ? WHERE adopter_id = ?";
        jdbcTemplate.update(sql, approvalStatus, id);
    }

    public Adopter mapRowToAdopter(SqlRowSet rowSet){
        int id = rowSet.getInt("adopter_id");
        String adopterName = rowSet.getString("adopter_name");
        String email = rowSet.getString("email");
        String phoneNumber = rowSet.getString("phone_number");
        String city = rowSet.getString("city");
        String state = rowSet.getString("state");
        String zipcode = rowSet.getString("zipcode");
        boolean hasCurrentPets = rowSet.getBoolean("any_pets");
        int numberOfCurrentPets = rowSet.getInt("number_pets");
        String approvalStatus = rowSet.getString("status");

        Adopter adopter = new Adopter(id, adopterName, email,phoneNumber,city,state,zipcode,hasCurrentPets,numberOfCurrentPets,approvalStatus);

        return adopter;
    }
}
