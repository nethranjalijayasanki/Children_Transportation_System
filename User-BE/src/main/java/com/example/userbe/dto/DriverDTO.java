package com.example.userbe.dto;
public class DriverDTO {
    private String name;
    private String licenseNumber;
    private String contactNumber;

    // Constructors
    public DriverDTO() {}

    public DriverDTO( String name, String licenseNumber, String contactNumber) {

        this.name = name;
        this.licenseNumber = licenseNumber;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
