package com.example.technikonproject.service.impl;

import com.example.technikonproject.domain.PropertyRepair;
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
    public List<PropertyRepair> findPropertyRepairsByRangeOfDates(LocalDate dateStart, LocalDate dateEnd) {
        return propertyRepairRepository.searchPropertyRepairsByDateOfScheduledRepairBetween(dateStart, dateEnd);
    }

    @Override
    public List<PropertyRepair> findPropertyRepairsByWebUserId(Long id) {
        return propertyRepairRepository.searchPropertyRepairsByWebUserId(id);
    }

    @Override
    public void updatePropertyRepair() {
    }

    @Override
    public void deletePropertyRepair(Long propertyRepairId) {
        propertyRepairRepository.deleteById(propertyRepairId);
    }
}
