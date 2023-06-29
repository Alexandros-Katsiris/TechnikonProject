package com.example.technikonproject.service;

import com.example.technikonproject.Model.Property;

import java.util.List;

public interface PropertyService {

    void addNewProperty(Property property);

    List<Property> searchProperty(Long e9number, Long tin);

    Property readProperty(Long e9Number);

    void update(Property property, Long e9Number);

    void deleteProperty(Long e9Number);
}
