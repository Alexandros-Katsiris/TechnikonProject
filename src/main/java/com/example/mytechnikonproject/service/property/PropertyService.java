package com.example.mytechnikonproject.service.property;

import com.example.mytechnikonproject.entity.Property;

import java.util.List;

public interface PropertyService {

    void addNewProperty(Property property);

    List<Property> searchProperty(Long e9number, Long tin);

    Property readProperty(Long e9Number);

    void update(Property property, Long e9Number);

    void deleteProperty(Long e9Number);
}
