package com.example.userbe.service;

import com.example.userbe.entity.Driver;
import com.example.userbe.dto.DriverDTO;
import com.example.userbe.entity.Driver;

import java.util.List;

public interface DriverService {
    List<DriverDTO> getAllDrivers();
    DriverDTO getDriverById(String driverId);
    DriverDTO createDriver(DriverDTO driverDTO);
    DriverDTO updateDriver(String driverId, DriverDTO driverDTO);
    void deleteDriver(String driverId);
    String generateDriverId();
}