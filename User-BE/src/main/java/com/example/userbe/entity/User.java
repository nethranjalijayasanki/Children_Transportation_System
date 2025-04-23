package com.example.userbe.entity;

import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "systemuser")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String username;
    private String email;
    private String password;
    private String role;


    public User(User byUsername, String typeOfHospital, String registrationNumber, int yearOfEstablishment, String address, String city, String district, String province, String zipCode, String officialEmail, String contactNumber, String emergencyContactNumber, String website, boolean hasBloodBank, String bloodBankContactPersonName, String bloodBankContactNumber, List<String> availableBloodGroups, String bloodBankLicenseNumber, List<String> healthMinistryApprovalCertificate, boolean emergencyBloodServiceAvailable, boolean bloodDonationCampFacility, int numberOfBloodStorageUnits, String userName) {
    }

    public User() {
    }

    public User(UUID id, String username, String email, String password, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
