package com.example.userbe.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class MechanicDTO {
    private Long id;
    private String name;
    private String specialization;
    private String contactNumber;
    private String email;
}
