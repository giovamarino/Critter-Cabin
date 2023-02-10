package com.techelevator.model;


public class Volunteer {

    private int applicationId;
    private String volunteerFirstName;
    private String volunteerLastName;
    private String email;
    private boolean over18;
    private boolean veterinary;
    private boolean cleaning;
    private boolean dataEntry;
    private boolean photography;
    private String status = "Pending";
    private String role;

    public Volunteer(int applicationId, String volunteerFirstName, String volunteerLastName, String email, boolean over18, boolean veterinary, boolean cleaning, boolean dataEntry, boolean photography, String status, String role) {
        this.applicationId = applicationId;
        this.volunteerFirstName = volunteerFirstName;
        this.volunteerLastName = volunteerLastName;
        this.email = email;
        this.over18 = over18;
        this.veterinary = veterinary;
        this.cleaning = cleaning;
        this.dataEntry = dataEntry;
        this.photography = photography;
        this.status = status;
        this.role = role;
    }

    public Volunteer() {
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getVolunteerFirstName() {
        return volunteerFirstName;
    }

    public void setVolunteerFirstName(String volunteerFirstName) {
        this.volunteerFirstName = volunteerFirstName;
    }

    public String getVolunteerLastName() {
        return volunteerLastName;
    }

    public void setVolunteerLastName(String volunteerLastName) {
        this.volunteerLastName = volunteerLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOver18() {
        return over18;
    }

    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isVeterinary() {
        return veterinary;
    }

    public void setVeterinary(boolean veterinary) {
        this.veterinary = veterinary;
    }

    public boolean isCleaning() {
        return cleaning;
    }

    public void setCleaning(boolean cleaning) {
        this.cleaning = cleaning;
    }

    public boolean isDataEntry() {
        return dataEntry;
    }

    public void setDataEntry(boolean dataEntry) {
        this.dataEntry = dataEntry;
    }

    public boolean isPhotography() {
        return photography;
    }

    public void setPhotography(boolean photography) {
        this.photography = photography;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
