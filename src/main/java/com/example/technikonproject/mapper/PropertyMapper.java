package com.example.technikonproject.mapper;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.transfer.resource.PropertyResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {WebUserMapper.class}, config = IgnoreUnmappedMapperConfig.class)
public interface PropertyMapper extends BaseMapper<Property, PropertyResource>{
}
