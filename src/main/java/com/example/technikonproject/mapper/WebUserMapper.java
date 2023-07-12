package com.example.technikonproject.mapper;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.transfer.resource.WebUserResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WebUserMapper extends BaseMapper<WebUser, WebUserResource>{
}