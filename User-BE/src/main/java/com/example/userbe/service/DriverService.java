package com.example.userbe.service;

import com.example.userbe.entity.Driver;
import com.example.userbe.dto.DriverDTO;
import com.example.userbe.entity.Driver;

import java.util.List;

public interface DriverService {
//    List<DriverDTO> getAllDrivers();
//    DriverDTO getDriverById(String driverId);
//    DriverDTO createDriver(DriverDTO driverDTO);
//    DriverDTO updateDriver(String driverId, DriverDTO driverDTO);
//    void deleteDriver(String driverId);
//    String generateDriverId();

    DriverDTO createDriver(DriverDTO driverDTO);
    DriverDTO getDriverById(Long id);
    List<DriverDTO> getAllDrivers();
    DriverDTO updateDriver(Long id, DriverDTO driverDTO);
    void deleteDriver(Long id);
    boolean existsByLicenseNumber(String licenseNumber);
    boolean existsByEmail(String email);
}