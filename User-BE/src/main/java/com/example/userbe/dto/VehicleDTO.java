package com.example.userbe.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class VehicleDTO {
    private Long id;
    private String registrationNumber;
    private String make;
    private String model;
    private Integer capacity;
    private LocalDate lastServiceDate;
    private String status;
}
