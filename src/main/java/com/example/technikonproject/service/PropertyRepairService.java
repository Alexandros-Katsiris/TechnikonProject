package com.example.technikonproject.service;

import com.example.technikonproject.Model.PropertyRepair;

import java.util.Date;
import java.util.List;

public interface PropertyRepairService {

    void addPropertyRepairId(PropertyRepair propertyRepair);

    List<PropertyRepair> searchPropertyRepairs(Date date);
    List<PropertyRepair> searchPropertyRepairs(Long tin);

    void updatePropertyRepair();

    void deletePropertyRepair(Long propertyRepairId);
}
