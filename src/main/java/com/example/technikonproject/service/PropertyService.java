package com.example.technikonproject.service;

import com.example.technikonproject.Model.Property;
import com.example.technikonproject.repository.PropertyRepository;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }
    public Property findById(Integer id){
        return propertyRepository.findById(id).orElseThrow(() -> new RuntimeException("This id doesnt exists."));
    }
}
