package com.example.technikonproject.service;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.dto.PropertyDto;

import java.util.List;

public interface PropertyService {

    void addNewProperty(Property property);

    List<Property> findPropertiesByTin(Long tin);

    Property findProperty(Long e9Number);

    void update(Property property, Long e9Number);

    void deleteProperty(Long e9Number);

    PropertyDto readPropertyDto(Long e9Number);
}
