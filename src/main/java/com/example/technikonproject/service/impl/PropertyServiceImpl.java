package com.example.technikonproject.service.impl;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.repository.PropertyRepository;
import com.example.technikonproject.service.PropertyService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl extends BaseServiceImpl<Property> implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Override
    public JpaRepository<Property, Long> getRepository() {
        return propertyRepository;
    }

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<Property> findPropertiesByTin(Long tin) {
        return propertyRepository.findByWebUserTin(tin).stream().toList();
    }

}
