package com.example.technikonproject.service;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.transfer.resource.PropertyDto;

import java.util.List;

public interface PropertyService extends BaseService<Property, Long> {

    List<Property> findPropertiesByTin(Long tin);

    void update(Property property);

    PropertyDto readPropertyDto(Long e9Number);
}
