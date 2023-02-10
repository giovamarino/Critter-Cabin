package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Adopter {

    private int adopterId;
    private String adopterName;
    private String email;
    private String phoneNumber;
    private String city;
    private String state;
    private String zipcode;
    @JsonProperty("anyPets")
    private boolean hasCurrentPets;
    @JsonProperty("numberOfPets")
    private int numberOfCurrentPets;
    private String approvalStatus;

    public Adopter(int adopterId, String adopterName, String email, String phoneNumber, String city, String state, String zipcode, boolean hasCurrentPets, int numberOfCurrentPets, String approvalStatus) {
        this.adopterId = adopterId;
        this.adopterName = adopterName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.hasCurrentPets = hasCurrentPets;
        this.numberOfCurrentPets = numberOfCurrentPets;
        this.approvalStatus = approvalStatus;
    }

    public int getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(int adopterId) {
        this.adopterId = adopterId;
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public boolean isHasCurrentPets() {
        return hasCurrentPets;
    }

    public void setHasCurrentPets(boolean hasCurrentPets) {
        this.hasCurrentPets = hasCurrentPets;
    }

    public int getNumberOfCurrentPets() {
        return numberOfCurrentPets;
    }

    public void setNumberOfCurrentPets(int numberOfCurrentPets) {
        this.numberOfCurrentPets = numberOfCurrentPets;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String status) {
        this.approvalStatus = status;
    }
}

