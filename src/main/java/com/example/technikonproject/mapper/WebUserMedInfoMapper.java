package com.example.technikonproject.mapper;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.transfer.resource.medInfo.WebUserMedInfoResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WebUserMedInfoMapper extends BaseMapper<WebUser, WebUserMedInfoResource>{
}
