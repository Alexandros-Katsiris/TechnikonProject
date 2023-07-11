package com.example.technikonproject.mapper;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.domain.PropertyRepair;
import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.dto.*;
import org.mapstruct.Mapper;

@Mapper()
public interface MapStructMapper {

    WebUserDto webUserToWebUserDto(WebUser webUser);

    PropertyDto propertyToPropertyDto(Property property);

    PropertyRepairDto propertyRepairToPropertyRepairDto(PropertyRepair propertyRepair);

    WebUserForRepairDto webUserToWebUserTinDto(WebUser webUser);

    PropertyForRepairDto propertyToPropertyE9Dto(Property property);

}

