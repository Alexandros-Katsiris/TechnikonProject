package com.example.technikonproject.service;

import com.example.technikonproject.domain.PropertyRepair;
import com.example.technikonproject.dto.PropertyRepairDto;

import java.time.LocalDate;
import java.util.List;

public interface PropertyRepairService {

    void addPropertyRepairId(PropertyRepair propertyRepair);

    List<PropertyRepairDto> findPropertyRepairsByRangeOfDates(LocalDate dateStart, LocalDate dateEnd);
    List<PropertyRepairDto> findPropertyRepairsByWebUserId(Long tin);

    void updatePropertyRepair(PropertyRepair propertyRepair);

    PropertyRepairDto findPropertyRepair(Long id);
}
