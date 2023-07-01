package com.example.technikonproject.service.impl;

import com.example.technikonproject.Model.PropertyRepair;
import com.example.technikonproject.repository.PropertyRepairRepository;
import com.example.technikonproject.service.PropertyRepairService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PropertyRepairServiceImpl implements PropertyRepairService {

    private final PropertyRepairRepository propertyRepairRepository;

    public PropertyRepairServiceImpl(PropertyRepairRepository propertyRepairRepository) {
        this.propertyRepairRepository = propertyRepairRepository;
    }

    @Override
    public void addPropertyRepairId(PropertyRepair propertyRepair) {
        propertyRepairRepository.save(propertyRepair);
    }

    @Override
    public List<PropertyRepair> searchPropertyRepairs(LocalDate date) {
        return propertyRepairRepository.searchPropertyRepair(date);
    }

    @Override
    public List<PropertyRepair> searchPropertyRepairs(Long tin) {
        return propertyRepairRepository.searchPropertyRepair(tin);
    }

    @Override
    public void updatePropertyRepair() {
    }

    @Override
    public void deletePropertyRepair(Long propertyRepairId) {
        propertyRepairRepository.deleteById(propertyRepairId);
    }
}
