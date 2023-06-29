package com.example.technikonproject.service.impl;

import com.example.technikonproject.Model.Property;
import com.example.technikonproject.repository.PropertyRepository;
import com.example.technikonproject.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public void addNewProperty(Property property) {
        propertyRepository.save(property);
    }

    @Override
    public List<Property> searchProperty(Long e9number, Long tin) {
        return propertyRepository.findById(e9number).stream().toList();
    }

    @Override
    public Property readProperty(Long e9Number) {
        return propertyRepository.readPropertyByE9Number(e9Number);
    }

    @Override
    public void update(Property property, Long e9Number) {
    }

    @Override
    public void deleteProperty(Long e9Number) {
        propertyRepository.deleteById(e9Number);
    }
}
