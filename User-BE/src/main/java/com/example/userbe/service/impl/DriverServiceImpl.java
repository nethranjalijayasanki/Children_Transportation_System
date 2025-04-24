package com.example.userbe.service.impl;

import com.example.userbe.dto.DriverDTO;
import com.example.userbe.entity.Driver;
import com.example.userbe.repo.DriverRepository;
import com.example.userbe.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository, ModelMapper modelMapper) {
        this.driverRepository = driverRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DriverDTO createDriver(DriverDTO driverDTO) {
        // Check if license number already exists
        if (driverRepository.existsByLicenseNumber(driverDTO.getLicenseNumber())) {
            throw new RuntimeException("Driver with license number " + driverDTO.getLicenseNumber() + " already exists");
        }

        // Check if email already exists
        if (driverRepository.existsByLicenseNumber(driverDTO.getLicenseNumber())) {
            throw new RuntimeException("Driver with email " + driverDTO.getLicenseNumber() + " already exists");
        }

        Driver driver = modelMapper.map(driverDTO, Driver.class);
        Driver savedDriver = driverRepository.save(driver);
        return modelMapper.map(savedDriver, DriverDTO.class);
    }

    @Override
    public DriverDTO getDriverById(Long id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
        return modelMapper.map(driver, DriverDTO.class);
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        List<Driver> drivers = driverRepository.findAll();
        return drivers.stream()
                .map(driver -> modelMapper.map(driver, DriverDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DriverDTO updateDriver(Long id, DriverDTO driverDTO) {
        Driver existingDriver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));

        // Check if license number is being changed to one that already exists
//        if (!existingDriver.getLicenseNumber().equals(driverDTO.getLicenseNumber()) &&
//                driverRepository.existsByLicenseNumber(driverDTO.getLicenseNumber())) {
//            throw new RuntimeException("Driver with license number " + driverDTO.getLicenseNumber() + " already exists");
//        }
//
////        // Check if email is being changed to one that already exists
//        if (!existingDriver.getLicenseNumber().equals(driverDTO.getLicenseNumber()) &&
//                driverRepository.existsByLicenseNumber(driverDTO.getLicenseNumber())) {
//            throw new RuntimeException("Driver with LicenseNumber " + driverDTO.getLicenseNumber() + " already exists");
//        }

        modelMapper.map(driverDTO, existingDriver);
        Driver updatedDriver = driverRepository.save(existingDriver);
        return modelMapper.map(updatedDriver, DriverDTO.class);
    }

    @Override
    public void deleteDriver(Long id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
        driverRepository.delete(driver);
    }

    @Override
    public boolean existsByLicenseNumber(String licenseNumber) {
        return driverRepository.existsByLicenseNumber(licenseNumber);
    }

    @Override
    public boolean existsByEmail(String email) {
        return driverRepository.existsByEmail(email);
    }
}