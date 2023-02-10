package com.techelevator.dao;

import com.techelevator.model.PetImage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetImageDao implements PetImageDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcPetImageDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PetImage> getAllPetImagesById(int petId) {
        List<PetImage> petImagesList = new ArrayList<>();
        String sql = "SELECT image_id, pet_id, pet_image, is_primary FROM pet_images " +
                "WHERE pet_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);
        while (results.next()){
            petImagesList.add(mapRowToPetImage(results));
        }
        return petImagesList;
    }

    @Override
    public PetImage getPetImageById(int imageId){
        PetImage petImage = new PetImage();
        String sql = "SELECT image_id, pet_id, pet_image, is_primary FROM pet_images WHERE image_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, imageId);
        if (results.next()){
            petImage = mapRowToPetImage(results);
        }
        return petImage;
    }

    @Override
    public PetImage addNewPetImage(PetImage petImage) {
        String sql = "INSERT INTO pet_images (pet_id, pet_image, is_primary) VALUES(?,?,?) RETURNING image_id";
        Integer imageId = jdbcTemplate.queryForObject(sql, Integer.class, petImage.getPetId(),petImage.getPetImage(), petImage.isPrimary());
        return getPetImageById(imageId);
    }



    @Override
    public void setPrimaryImage(int id) {
        List<PetImage> petImageListPrimaryImage = new ArrayList<>();
        String sql = "SELECT image_id, pet_id, pet_image, is_primary WHERE is_primary = true";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            PetImage petImage = mapRowToPetImage(results);
            sql = "UPDATE pet_images SET is_primary = false WHERE image_id = ?";
            jdbcTemplate.update(sql, petImage.getPetImageId());
        }
        sql = "UPDATE pet_images SET is_primary = true WHERE image_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public boolean deletePetImage(int id) {
        boolean success=false;
        String sql = "DELETE FROM pet_images WHERE image_id = ?";
        int linesUpdated = jdbcTemplate.update(sql,id);
        if(linesUpdated==1){
            success=true;
        }
        return success;
    }


    @Override
    public PetImage getPrimaryImage(int petId) {
        PetImage petImage = new PetImage();
        String sql = "SELECT image_id, pet_id, pet_image, is_primary FROM pet_images WHERE is_primary = true";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()){
            petImage = mapRowToPetImage(results);
        }
        return petImage;
    }

    @Override
    public PetImage addAdditional(int petId, String petImage) {
        String sql = "INSERT INTO pet_images (pet_id, pet_image, is_primary) VALUES(?,?,?) RETURNING image_id";
        Integer imageId = jdbcTemplate.queryForObject(sql, Integer.class, petId, petImage, false);
        return getPetImageById(imageId);
    }

    private PetImage mapRowToPetImage(SqlRowSet rowSet){
        PetImage petImage = new PetImage();
        petImage.setPetImageId(rowSet.getInt("image_id"));
        petImage.setPetImage(rowSet.getString("pet_image"));
        petImage.setPrimary(rowSet.getBoolean("is_primary"));
        petImage.setPetId(rowSet.getInt("pet_id"));
        return petImage;
    }
}
