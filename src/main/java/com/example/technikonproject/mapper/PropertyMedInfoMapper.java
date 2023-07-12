package com.example.technikonproject.mapper;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.transfer.resource.medInfo.PropertyMedInfoResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface PropertyMedInfoMapper extends BaseMapper<Property, PropertyMedInfoResource>{
}
