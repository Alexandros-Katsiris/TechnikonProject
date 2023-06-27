package com.example.mytechnikonproject.service.webUser;

import com.example.mytechnikonproject.entity.WebUser;

import java.util.List;


public interface WebUserService {

    void addWebUser(WebUser webUser);
    WebUser readWebUser(Long tin);
    List<WebUser> searchWebUser(Long tinNumber, String email, String name);
    //void updateWebUser(Integer tinNumber, String streetName, Integer streetNumber, Integer zipcode, String email, String password) throws Exception;
    void updateWebUser(WebUser webUser, Long tinNumber) throws Exception;

    void deleteWebUser(Long tinNumber);
}
