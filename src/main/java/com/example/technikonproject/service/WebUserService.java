package com.example.technikonproject.service;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.dto.WebUserDto;

import java.util.List;


public interface WebUserService extends BaseService<WebUser, Long> {

    WebUser readWebUser(Long tin);

    List<WebUser> readWebUserByFirstName(String name);

    WebUser readWebUserByEmail(String email);

    void update(WebUser webuser);

    WebUserDto readDto(Long id);

    void deleteByTin(Long tin);
}
