package com.example.userbe.dto;

import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RouteDetailsDTO {
    private Long id;
    private String routeName;
    private String startPoint;
    private String endPoint;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long vehicleId;
    private List<Long> passengerIds;

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public List<Long> getPassengerIds() {
        return passengerIds;
    }

    public void setPassengerIds(List<Long> passengerIds) {
        this.passengerIds = passengerIds;
    }
}
