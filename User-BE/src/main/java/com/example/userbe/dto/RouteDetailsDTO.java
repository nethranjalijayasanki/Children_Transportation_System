package com.example.userbe.dto;

import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class RouteDetailsDTO {
    private Long id;
    private String routeName;
    private String startPoint;
    private String endPoint;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long vehicleId;
    private List<Long> passengerIds;
}
