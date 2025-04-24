package com.example.userbe.repo;
import com.example.userbe.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
//    Optional<Driver> findByDriverId(String driverId);
//    Optional<Driver> findByLicenseNumber(String licenseNumber);
//    boolean existsByLicenseNumber(String licenseNumber);

    boolean existsByLicenseNumber(String licenseNumber);
    boolean existsByEmail(String email);
}
