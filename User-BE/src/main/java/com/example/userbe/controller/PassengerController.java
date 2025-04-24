package com.example.userbe.controller;

import com.example.userbe.dto.PassengerDTO;
import com.example.userbe.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping("/save")
    public ResponseEntity<PassengerDTO> createPassenger(@RequestBody PassengerDTO passengerDTO) {
        PassengerDTO createdPassenger = passengerService.createPassenger(passengerDTO);
        return ResponseEntity.ok(createdPassenger);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable Long id) {
        PassengerDTO passengerDTO = passengerService.getPassengerById(id);
        return ResponseEntity.ok(passengerDTO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
        List<PassengerDTO> passengers = passengerService.getAllPassengers();
        return ResponseEntity.ok(passengers);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PassengerDTO> updatePassenger(@PathVariable Long id, @RequestBody PassengerDTO passengerDTO) {
        PassengerDTO updatedPassenger = passengerService.updatePassenger(id, passengerDTO);
        return ResponseEntity.ok(updatedPassenger);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}
