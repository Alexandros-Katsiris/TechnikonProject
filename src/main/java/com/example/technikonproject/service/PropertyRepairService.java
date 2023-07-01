package com.example.technikonproject.service;

import com.example.technikonproject.Model.PropertyRepair;

import java.time.LocalDate;
import java.util.List;

public interface PropertyRepairService {

    void addPropertyRepairId(PropertyRepair propertyRepair);

    List<PropertyRepair> searchPropertyRepairs(LocalDate date);
    List<PropertyRepair> searchPropertyRepairs(Long tin);

    void updatePropertyRepair();

    void deletePropertyRepair(Long propertyRepairId);
}
