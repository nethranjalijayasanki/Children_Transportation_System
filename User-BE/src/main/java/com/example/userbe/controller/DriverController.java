package com.example.userbe.controller;
import com.example.userbe.dto.DriverDTO;
import com.example.userbe.dto.ErrorResponse;
import com.example.userbe.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/drivers")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        List<DriverDTO> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<?> getDriverById(@PathVariable String driverId) {
        DriverDTO driver = driverService.getDriverById(driverId);
        if (driver != null) {
            return ResponseEntity.ok(driver);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                            "Driver not found with ID: " + driverId,
                            System.currentTimeMillis()));
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> createDriver(@RequestBody @Valid DriverDTO driverDTO) {
        System.out.println("save");
        try {
            DriverDTO createdDriver = driverService.createDriver(driverDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdDriver);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                            e.getMessage(),
                            System.currentTimeMillis()));
        }
    }

    @PutMapping("/{driverId}")
    public ResponseEntity<?> updateDriver(@PathVariable String driverId, @RequestBody DriverDTO driverDTO) {
        try {
            DriverDTO updatedDriver = driverService.updateDriver(driverId, driverDTO);
            return ResponseEntity.ok(updatedDriver);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                            e.getMessage(),
                            System.currentTimeMillis()));
        }
    }

    @DeleteMapping("/{driverId}")
    public ResponseEntity<?> deleteDriver(@PathVariable String driverId) {
        try {
            driverService.deleteDriver(driverId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                            e.getMessage(),
                            System.currentTimeMillis()));
        }
    }
}
