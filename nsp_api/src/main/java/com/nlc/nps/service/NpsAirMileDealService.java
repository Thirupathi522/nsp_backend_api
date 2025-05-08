package com.nlc.nps.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlc.nps.dto.NpsAirMileRequestDTO;
import com.nlc.nps.entity.NpsAirMileDealEntity;
import com.nlc.nps.repository.NpsAirMileDealRepository;

@Service
public class NpsAirMileDealService {

    @Autowired
    private NpsAirMileDealRepository repository;

    public NpsAirMileRequestDTO save(NpsAirMileRequestDTO dto) {
        NpsAirMileDealEntity entity = mapToEntity(dto);
        NpsAirMileDealEntity saved = repository.save(entity);
        return mapToDTO(saved);
    }

    public List<NpsAirMileRequestDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Optional<NpsAirMileRequestDTO> findById(Long id) {
        return repository.findById(id).map(this::mapToDTO);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private NpsAirMileDealEntity mapToEntity(NpsAirMileRequestDTO dto) {
        NpsAirMileDealEntity entity = new NpsAirMileDealEntity();
        entity.setOrgId(dto.getOrgId());
        entity.setItemId(dto.getItemId());
        entity.setAirmailCalculationMethod(dto.getAirmailCalculationMethod());
        entity.setAirmailCalculationAction(dto.getAirmailCalculationAction());
        return entity;
    }

    private NpsAirMileRequestDTO mapToDTO(NpsAirMileDealEntity entity) {
    	NpsAirMileRequestDTO dto = new NpsAirMileRequestDTO();
        dto.setOrgId(entity.getOrgId());
        dto.setItemId(entity.getItemId());
        dto.setAirmailCalculationMethod(entity.getAirmailCalculationMethod());
        dto.setAirmailCalculationAction(entity.getAirmailCalculationAction());
        return dto;
    }
    
    public Optional<NpsAirMileRequestDTO> findByItemId(String itemId) {
        return repository.findByItemId(itemId).map(this::mapToDTO);
    }

}
