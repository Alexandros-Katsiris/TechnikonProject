package com.example.technikonproject.service.impl;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.dto.PropertyDto;
import com.example.technikonproject.mapper.MapStructMapper;
import com.example.technikonproject.repository.PropertyRepository;
import com.example.technikonproject.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl extends BaseServiceImpl<Property> implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final MapStructMapper mapStructMapper;


    public JpaRepository<Property, Long> getRepository() {
        return propertyRepository;
    }



    @Override
    public PropertyDto readPropertyDto(Long e9Number) {
        return mapStructMapper.propertyToPropertyDto(propertyRepository.findPropertyByE9Number(e9Number));
    }

    @Override
    public List<Property> findPropertiesByTin(Long tin) {
        return propertyRepository.findByWebUserTin(tin).stream().toList();
    }


    @Override
    public void update(Property property, Long e9Number) {
        propertyRepository.save(property);
    }

    @Override
    public void deleteProperty(Long e9Number) {
        propertyRepository.deleteById(e9Number);
    }
}
