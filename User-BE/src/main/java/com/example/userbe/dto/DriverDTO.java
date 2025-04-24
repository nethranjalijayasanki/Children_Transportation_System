package com.example.userbe.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String licenseNumber;
    private LocalDate licenseExpiryDate;
    private String contactNumber;
    private String email;
    private String address;
    private String status;

    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }


}
