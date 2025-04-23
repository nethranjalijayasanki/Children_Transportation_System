package com.example.userbe.service.impl;

import com.example.userbe.dto.DriverDTO;
        import com.example.userbe.entity.Driver;
        import com.example.userbe.repo.DriverRepository;
        import com.example.userbe.service.DriverService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;
        import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        return driverRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DriverDTO getDriverById(String driverId) {
        Optional<Driver> driver = driverRepository.findByDriverId(driverId);
        return driver.map(this::convertToDTO).orElse(null);
    }

    @Override
    public DriverDTO createDriver(DriverDTO driverDTO) {
        // Check if license number already exists
        if (driverRepository.existsByLicenseNumber(driverDTO.getLicenseNumber())) {
            throw new RuntimeException("Driver with this license number already exists");
        }

        // Generate driver ID
        String driverId = generateDriverId();

        Driver driver = new Driver();
        driver.setDriverId(driverId);
        driver.setName(driverDTO.getName());
        driver.setLicenseNumber(driverDTO.getLicenseNumber());
        driver.setContactNumber(driverDTO.getContactNumber());

        Driver savedDriver = driverRepository.save(driver);
        return convertToDTO(savedDriver);
    }

    @Override
    public DriverDTO updateDriver(String driverId, DriverDTO driverDTO) {
        Optional<Driver> optionalDriver = driverRepository.findByDriverId(driverId);
        if (optionalDriver.isEmpty()) {
            throw new RuntimeException("Driver not found with ID: " + driverId);
        }

        Driver existingDriver = optionalDriver.get();

        // Check if the new license number is already used by another driver
        if (!existingDriver.getLicenseNumber().equals(driverDTO.getLicenseNumber())){
            if (driverRepository.existsByLicenseNumber(driverDTO.getLicenseNumber())) {
                throw new RuntimeException("Another driver already has this license number");
            }
        }

        existingDriver.setName(driverDTO.getName());
        existingDriver.setLicenseNumber(driverDTO.getLicenseNumber());
        existingDriver.setContactNumber(driverDTO.getContactNumber());

        Driver updatedDriver = driverRepository.save(existingDriver);
        return convertToDTO(updatedDriver);
    }

    @Override
    public void deleteDriver(String driverId) {
        Optional<Driver> driver = driverRepository.findByDriverId(driverId);
        if (driver.isPresent()) {
            driverRepository.delete(driver.get());
        } else {
            throw new RuntimeException("Driver not found with ID: " + driverId);
        }
    }

    @Override
    public String generateDriverId() {
        long count = driverRepository.count() + 1;
        return "D" + String.format("%03d", count);
    }

    private DriverDTO convertToDTO(Driver driver) {
        return new DriverDTO(
                driver.getName(),
                driver.getLicenseNumber(),
                driver.getContactNumber()
        );
    }
}
