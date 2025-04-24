package com.example.userbe.service.impl;

import com.example.userbe.dto.RouteDetailsDTO;
import com.example.userbe.entity.Passenger;
import com.example.userbe.entity.RouteDetails;
import com.example.userbe.entity.Vehicle;
import com.example.userbe.repo.PassengerRepository;
import com.example.userbe.repo.RouteDetailsRepository;
import com.example.userbe.repo.VehicleRepository;
import com.example.userbe.service.RouteDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RouteDetailsServiceImpl implements RouteDetailsService {

    private final RouteDetailsRepository routeDetailsRepository;
    private final VehicleRepository vehicleRepository;
    private final PassengerRepository passengerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RouteDetailsServiceImpl(RouteDetailsRepository routeDetailsRepository,
                                   VehicleRepository vehicleRepository,
                                   PassengerRepository passengerRepository,
                                   ModelMapper modelMapper) {
        this.routeDetailsRepository = routeDetailsRepository;
        this.vehicleRepository = vehicleRepository;
        this.passengerRepository = passengerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RouteDetailsDTO createRouteDetails(RouteDetailsDTO routeDetailsDTO) {
        RouteDetails routeDetails = modelMapper.map(routeDetailsDTO, RouteDetails.class);

        Vehicle vehicle = vehicleRepository.findById(routeDetailsDTO.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + routeDetailsDTO.getVehicleId()));
        routeDetails.setVehicle(vehicle);


        List<Passenger> passengers = passengerRepository.findAllById(routeDetailsDTO.getPassengerIds());
        routeDetails.setPassengers(passengers);

        RouteDetails savedRouteDetails = routeDetailsRepository.save(routeDetails);
        return modelMapper.map(savedRouteDetails, RouteDetailsDTO.class);
    }

    @Override
    public RouteDetailsDTO getRouteDetailsById(Long id) {
        RouteDetails routeDetails = routeDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RouteDetails not found with id: " + id));
        return modelMapper.map(routeDetails, RouteDetailsDTO.class);
    }

    @Override
    public List<RouteDetailsDTO> getAllRouteDetails() {
        List<RouteDetails> routeDetailsList = routeDetailsRepository.findAll();
        return routeDetailsList.stream()
                .map(routeDetails -> modelMapper.map(routeDetails, RouteDetailsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RouteDetailsDTO updateRouteDetails(Long id, RouteDetailsDTO routeDetailsDTO) {
        RouteDetails existingRouteDetails = routeDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RouteDetails not found with id: " + id));

        modelMapper.map(routeDetailsDTO, existingRouteDetails);

        // Update vehicle if changed
        if (routeDetailsDTO.getVehicleId() != null) {
            Vehicle vehicle = vehicleRepository.findById(routeDetailsDTO.getVehicleId())
                    .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + routeDetailsDTO.getVehicleId()));
            existingRouteDetails.setVehicle(vehicle);
        }

        // Update passengers if changed
        if (routeDetailsDTO.getPassengerIds() != null && !routeDetailsDTO.getPassengerIds().isEmpty()) {
            List<Passenger> passengers = passengerRepository.findAllById(routeDetailsDTO.getPassengerIds());
            existingRouteDetails.setPassengers(passengers);
        }

        RouteDetails updatedRouteDetails = routeDetailsRepository.save(existingRouteDetails);
        return modelMapper.map(updatedRouteDetails, RouteDetailsDTO.class);
    }

    @Override
    public void deleteRouteDetails(Long id) {
        RouteDetails routeDetails = routeDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RouteDetails not found with id: " + id));
        routeDetailsRepository.delete(routeDetails);
    }
}
