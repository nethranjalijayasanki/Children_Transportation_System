package com.example.userbe.service.impl;

import com.example.userbe.dto.MechanicDTO;
import com.example.userbe.entity.Mechanic;
import com.example.userbe.repo.MechanicRepository;
import com.example.userbe.service.MechanicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MechanicServiceImpl implements MechanicService {
    private final MechanicRepository mechanicRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MechanicServiceImpl(MechanicRepository mechanicRepository, ModelMapper modelMapper) {
        this.mechanicRepository = mechanicRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MechanicDTO createMechanic(MechanicDTO mechanicDTO) {
        Mechanic mechanic = modelMapper.map(mechanicDTO, Mechanic.class);
        Mechanic savedMechanic = mechanicRepository.save(mechanic);
        return modelMapper.map(savedMechanic, MechanicDTO.class);
    }

    @Override
    public MechanicDTO getMechanicById(Long id) {
        Mechanic mechanic = mechanicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mechanic not found with id: " + id));
        return modelMapper.map(mechanic, MechanicDTO.class);
    }

    @Override
    public List<MechanicDTO> getAllMechanics() {
        List<Mechanic> mechanics = mechanicRepository.findAll();
        return mechanics.stream()
                .map(mechanic -> modelMapper.map(mechanic, MechanicDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MechanicDTO updateMechanic(Long id, MechanicDTO mechanicDTO) {
        Mechanic existingMechanic = mechanicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mechanic not found with id: " + id));

        modelMapper.map(mechanicDTO, existingMechanic);
        Mechanic updatedMechanic = mechanicRepository.save(existingMechanic);
        return modelMapper.map(updatedMechanic, MechanicDTO.class);
    }

    @Override
    public void deleteMechanic(Long id) {
        Mechanic mechanic = mechanicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mechanic not found with id: " + id));
        mechanicRepository.delete(mechanic);
    }
}
