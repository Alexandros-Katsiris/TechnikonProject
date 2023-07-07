package com.example.technikonproject.mapper;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.domain.subDomain.Address;
import com.example.technikonproject.dto.AddressDto;
import com.example.technikonproject.dto.PropertyDto;
import com.example.technikonproject.dto.WebUserDto;
import org.mapstruct.Mapper;

@Mapper()
public interface MapStructMapper {

    WebUserDto webUserToWebUserDto(WebUser webUser);

    AddressDto addressToAddressDto(Address address);

    PropertyDto propertyToPropertyDto(Property property);
}
