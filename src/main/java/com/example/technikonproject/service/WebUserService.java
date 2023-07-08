package com.example.technikonproject.service;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.dto.WebUserDto;

import java.util.List;


public interface WebUserService extends BaseService<WebUser, Long> {

    WebUserDto readWebUser(Long tin);

    List<WebUserDto> readWebUserByFirstName(String name);

    WebUserDto readWebUserByEmail(String email);

    void update(WebUser webuser);

    WebUserDto readDto(Long id);

    void deleteByTin(Long tin);
}
