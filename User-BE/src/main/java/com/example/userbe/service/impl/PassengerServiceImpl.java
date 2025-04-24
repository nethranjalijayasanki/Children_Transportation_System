package com.example.userbe.service.impl;

import com.example.userbe.dto.PassengerDTO;
import com.example.userbe.entity.Passenger;
import com.example.userbe.repo.PassengerRepository;
import com.example.userbe.service.PassengerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, ModelMapper modelMapper) {
        this.passengerRepository = passengerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PassengerDTO createPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
        Passenger savedPassenger = passengerRepository.save(passenger);
        return modelMapper.map(savedPassenger, PassengerDTO.class);
    }


    @Override
    public PassengerDTO getPassengerById(Long id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found with id: " + id));
        return modelMapper.map(passenger, PassengerDTO.class);
    }

    @Override
    public List<PassengerDTO> getAllPassengers() {
        List<Passenger> passengers = passengerRepository.findAll();
        return passengers.stream()
                .map(passenger -> modelMapper.map(passenger, PassengerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PassengerDTO updatePassenger(Long id, PassengerDTO passengerDTO) {
        Passenger existingPassenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found with id: " + id));

        modelMapper.map(passengerDTO, existingPassenger);
        Passenger updatedPassenger = passengerRepository.save(existingPassenger);
        return modelMapper.map(updatedPassenger, PassengerDTO.class);
    }

    @Override
    public void deletePassenger(Long id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found with id: " + id));
        passengerRepository.delete(passenger);
    }
}