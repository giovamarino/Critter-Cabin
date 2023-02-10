package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.Volunteer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVolunteerDao implements VolunteerDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcVolunteerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Volunteer> getAllVolunteers() {
        List<Volunteer> volunteersList = new ArrayList<>();
        String sql = "SELECT application_id, first_name, last_name, email, over_18, veterinary, cleaning, data_entry, photography, status FROM volunteers";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            volunteersList.add(mapRowToVolunteer(results));
        }
        return volunteersList;
    }

    @Override
    public Volunteer getVolunteerById(int id) {
        Volunteer volunteer = null;
        String sql = "SELECT application_id, first_name, last_name, email, over_18, veterinary, cleaning, data_entry, photography, status FROM volunteers WHERE application_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            volunteer = mapRowToVolunteer(results);
        }
        return volunteer;
    }
    @Override
    public List<Volunteer> getVolunteersByStatus(String status) {
        List<Volunteer> volunteersList = new ArrayList<>();
        String sql = "SELECT application_id, first_name, last_name, email, over_18, veterinary, cleaning, data_entry, photography, status FROM volunteers WHERE status = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, status);

        while(results.next()){
            volunteersList.add(mapRowToVolunteer(results));
        }
        return volunteersList;
    }




    @Override
    public void updateStatus(int id, String approvalStatus) {
        String sql = "UPDATE volunteers SET status = ? WHERE application_id = ?";
        jdbcTemplate.update(sql, approvalStatus, id);
    }

    @Override
    public Volunteer applyToVolunteer(Volunteer volunteer) {
        String sql = "INSERT INTO volunteers (first_name, last_name, email, over_18, veterinary, cleaning, data_entry, photography, status) VALUES(?,?,?,?,?,?,?,?,?) RETURNING application_id";

        Integer applicationId;

        applicationId = jdbcTemplate.queryForObject(sql, Integer.class, volunteer.getVolunteerFirstName(), volunteer.getVolunteerLastName(), volunteer.getEmail(), volunteer.isOver18(), volunteer.isVeterinary(), volunteer.isCleaning(), volunteer.isDataEntry(), volunteer.isPhotography(), volunteer.getStatus());

        return getVolunteerById(applicationId);
    }

    @Override
    public List<Volunteer> getVolunteerByStatusWithRole(String status) {
        List<Volunteer> volunteersList = new ArrayList<>();
        String sql = "SELECT volunteers.application_id, first_name, last_name, email, over_18, veterinary, cleaning, data_entry, photography, status, role \n" +
                "FROM volunteers \n" + "JOIN users ON users.application_id = volunteers.application_id\n" +
                "WHERE status = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, status);

        while(results.next()){
            Volunteer temp = mapRowToVolunteer(results);
            temp.setRole(results.getString("role"));
            volunteersList.add(temp);
        }
        return volunteersList;
    }

    private Volunteer mapRowToVolunteer(SqlRowSet rowSet){
        Volunteer volunteer = new Volunteer();
        volunteer.setApplicationId(rowSet.getInt("application_id"));
        volunteer.setVolunteerFirstName(rowSet.getString("first_name"));
        volunteer.setVolunteerLastName(rowSet.getString("last_name"));
        volunteer.setEmail(rowSet.getString("email"));
        volunteer.setOver18(rowSet.getBoolean("over_18"));
        volunteer.setVeterinary(rowSet.getBoolean("veterinary"));
        volunteer.setCleaning(rowSet.getBoolean("cleaning"));
        volunteer.setDataEntry(rowSet.getBoolean("data_entry"));
        volunteer.setPhotography(rowSet.getBoolean("photography"));
        volunteer.setStatus(rowSet.getString("status"));
        return volunteer;
    }
}


//    //SELECT application_id, first_name, last_name, email, over_18, veterinary, cleaning, data_entry, photography, status FROM volunteers WHERE status = ?
//"SELECT volunteers.application_id, first_name, last_name, email, over_18, veterinary, cleaning, data_entry, photography, status, role \n" + "FROM volunteers \n" + "JOIN users ON users.application_id = volunteers.application_id\n" +
//       "WHERE status = ?;";