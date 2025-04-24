package com.example.userbe.service;

import com.example.userbe.dto.MechanicDTO;

import java.util.List;

public interface MechanicService {
    MechanicDTO createMechanic(MechanicDTO mechanicDTO);
    MechanicDTO getMechanicById(Long id);
    List<MechanicDTO> getAllMechanics();
    MechanicDTO updateMechanic(Long id, MechanicDTO mechanicDTO);
    void deleteMechanic(Long id);
}
