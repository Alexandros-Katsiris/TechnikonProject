package com.example.technikonproject.service.impl;

import com.example.technikonproject.domain.PropertyRepair;
import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.domain.enums.RepairStatus;
import com.example.technikonproject.domain.enums.RepairType;
import com.example.technikonproject.dto.PropertyRepairDto;
import com.example.technikonproject.mapper.MapStructMapper;
import com.example.technikonproject.repository.PropertyRepairRepository;
import com.example.technikonproject.service.PropertyRepairService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PropertyRepairServiceImpl implements PropertyRepairService {

    private final PropertyRepairRepository propertyRepairRepository;
    private final MapStructMapper mapStructMapper;

    public PropertyRepairServiceImpl(PropertyRepairRepository propertyRepairRepository, MapStructMapper mapStructMapper) {
        this.propertyRepairRepository = propertyRepairRepository;
        this.mapStructMapper = mapStructMapper;
    }

    @Override
    public PropertyRepairDto findPropertyRepair(Long id){
        return mapStructMapper.propertyRepairToPropertyRepairDto(propertyRepairRepository.findById(id).orElseThrow());
    }

    @Override
    public void addPropertyRepairId(PropertyRepair propertyRepair) {
        propertyRepairRepository.save(propertyRepair);
    }

    @Override
    public List<PropertyRepairDto> findPropertyRepairsByRangeOfDates(LocalDate dateStart, LocalDate dateEnd) {
        List<PropertyRepair> prRepairs = propertyRepairRepository.searchPropertyRepairsByDateOfScheduledRepairBetween(dateStart, dateEnd);
        return prRepairs.stream().map(mapStructMapper::propertyRepairToPropertyRepairDto).toList();
    }

    @Override
    public List<PropertyRepairDto> findPropertyRepairsByWebUserId(Long id) {
        List<PropertyRepair> prRepairs = propertyRepairRepository.searchPropertyRepairsByWebUserId(id);
        return prRepairs.stream().map(mapStructMapper::propertyRepairToPropertyRepairDto).toList();
    }

    @Override
    public void updatePropertyRepair(PropertyRepair propertyRepair) {
        PropertyRepair propertyRepairOld = propertyRepairRepository.findById(propertyRepair.getId()).orElseThrow();
        propertyRepairOld.setRepairStatus(updatePropertyRepairStatus(propertyRepairOld, propertyRepair));
        propertyRepairOld.setCostOfRepair(updatePropertyCostOfRepair(propertyRepairOld, propertyRepair));
        propertyRepairOld.setRepairType(updatePropertyRepairType(propertyRepairOld, propertyRepair));
        propertyRepairOld.setWebUser(updatePropertyRepairWebUser(propertyRepairOld, propertyRepair));
        propertyRepairOld.setDateOfScheduledRepair(updatePropertyRepairDateOfScheduledRepair(propertyRepairOld, propertyRepair));
        propertyRepairOld.setDescription(updatePropertyRepairDescription(propertyRepairOld, propertyRepair));
        propertyRepairRepository.save(propertyRepairOld);
    }

    public void updatePropertyRepairShortDescription(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
    }

    private RepairType updatePropertyRepairType(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
        if (propertyRepairNew.getRepairType() != null &&
                !propertyRepairNew.getRepairType().equals(propertyRepairOld.getRepairType()))
            return propertyRepairNew.getRepairType() ;
        return propertyRepairOld.getRepairType();
    }

    private RepairStatus updatePropertyRepairStatus(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
        if (propertyRepairNew.getRepairStatus() != null &&
                !propertyRepairNew.getRepairStatus().equals(propertyRepairOld.getRepairStatus())) {
            return propertyRepairNew.getRepairStatus();
        }
        return propertyRepairOld.getRepairStatus();
    }

    private BigDecimal updatePropertyCostOfRepair(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
        if (propertyRepairNew.getCostOfRepair() != null &&
                !propertyRepairNew.getCostOfRepair().equals(propertyRepairOld.getCostOfRepair())) {
            return propertyRepairNew.getCostOfRepair();
        }
        return propertyRepairOld.getCostOfRepair();

    }

    private WebUser updatePropertyRepairWebUser(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
        if (propertyRepairNew.getWebUser() != null &&
                !propertyRepairNew.getWebUser().equals(propertyRepairOld.getWebUser())) {
            return propertyRepairNew.getWebUser();
        }
        return propertyRepairOld.getWebUser();
    }

    private LocalDate updatePropertyRepairDateOfScheduledRepair(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
        if (propertyRepairNew.getDateOfScheduledRepair() == null &&
                propertyRepairNew.getDateOfScheduledRepair().isEqual(propertyRepairOld.getDateOfScheduledRepair()))
            return propertyRepairOld.getDateOfScheduledRepair();
        return propertyRepairNew.getDateOfScheduledRepair();
    }



    private String updatePropertyRepairDescription(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
        if (propertyRepairNew.getDescription().isEmpty() &&
                propertyRepairNew.getDescription().equals(propertyRepairOld.getDescription()))
            return propertyRepairOld.getDescription();
        return propertyRepairNew.getDescription();
    }

}
