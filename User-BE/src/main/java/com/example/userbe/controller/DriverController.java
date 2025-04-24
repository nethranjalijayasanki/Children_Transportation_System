package com.example.userbe.controller;

import com.example.userbe.dto.DriverDTO;
import com.example.userbe.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drivers")
public class DriverController {
    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/save")
    public ResponseEntity<DriverDTO> createDriver(@RequestBody DriverDTO driverDTO) {
        DriverDTO createdDriver = driverService.createDriver(driverDTO);
        return ResponseEntity.ok(createdDriver);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<DriverDTO> getDriverById(@PathVariable Long id) {
        DriverDTO driverDTO = driverService.getDriverById(id);
        return ResponseEntity.ok(driverDTO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        List<DriverDTO> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(drivers);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DriverDTO> updateDriver(@PathVariable Long id, @RequestBody DriverDTO driverDTO) {
        DriverDTO updatedDriver = driverService.updateDriver(id, driverDTO);
        return ResponseEntity.ok(updatedDriver);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists/license/{licenseNumber}")
    public ResponseEntity<Boolean> existsByLicenseNumber(@PathVariable String licenseNumber) {
        boolean exists = driverService.existsByLicenseNumber(licenseNumber);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/exists/email/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        boolean exists = driverService.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }
}
