package com.example.technikonproject.mapper;

import com.example.technikonproject.domain.PropertyRepair;
import com.example.technikonproject.transfer.resource.PropertyRepairResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PropertyRepairMapper extends BaseMapper<PropertyRepair, PropertyRepairResource> {
}
