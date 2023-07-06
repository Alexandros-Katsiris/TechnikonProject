package com.example.technikonproject.service;

import com.example.technikonproject.domain.WebUser;

import java.util.List;


public interface WebUserService {

    void addWebUser(WebUser webUser);
    WebUser readWebUser(Long tin);
    List<WebUser> readWebUserByFirstName(String name);
    WebUser readWebUserByEmail(String email);
    void updateWebUser(WebUser webuser) throws Exception;
    void deleteWebUser(Long tinNumber);
}
