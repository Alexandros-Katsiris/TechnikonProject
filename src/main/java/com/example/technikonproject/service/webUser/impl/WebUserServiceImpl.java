package com.example.technikonproject.service.webUser.impl;

import com.example.technikonproject.Model.enums.Address;
import com.example.technikonproject.Model.WebUser;
import com.example.technikonproject.repository.WebUserRepository;
import com.example.technikonproject.service.webUser.WebUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebUserServiceImpl implements WebUserService {
    private final WebUserRepository webUserRepository;

    public WebUserServiceImpl(WebUserRepository webUserRepository) {
        this.webUserRepository = webUserRepository;
    }


    @Override
    public void addWebUser(WebUser webUser) {
        webUserRepository.save(webUser);
    }

    @Override
    public WebUser readWebUser(Long tin){
        return webUserRepository.readWebUserByTin(tin);
        //return webUserRepository.findById(tin).orElseThrow();
        //return webUser;
    }

    @Override
    public List<WebUser> searchWebUser(Long tin, String email, String name) {
        return webUserRepository.findById(tin).stream().toList();
    }

    @Override
    ///public void updateWebUser(Integer tinNumber, String streetName, Integer streetNumber, Integer zipcode, String email, String password) throws Exception {
    public void updateWebUser(WebUser webUser, Long tin) throws Exception {
            WebUser webUserUpdated = webUserRepository.findById(tin).orElseThrow(
                    ()-> new RuntimeException("owner with id -> %s does not exist".formatted(tin)));
            Address address = webUser.getAddress();
            if(!webUser.getAddress().getStreetName().isEmpty())
                address.setStreetName(webUser.getAddress().getStreetName());
            if(webUser.getAddress().getStreetNumber() > 0)
                address.setStreetNumber(webUser.getAddress().getStreetNumber());
            if(webUser.getAddress().getZipcode() > 0)
                address.setZipcode(webUser.getAddress().getZipcode());
            if(!webUser.getEmail().isEmpty())
                webUserUpdated.setEmail(webUser.getEmail());
            if(!webUser.getPassword().isEmpty())
                webUser.setPassword(webUser.getPassword());
            webUserUpdated.setAddress(address);
            webUserRepository.save(webUserUpdated);
    }

    @Override
    public void deleteWebUser(Long tin) {
        if(webUserRepository.existsById(tin))
            webUserRepository.deleteById(tin);
        else
            System.out.println("No User Found");
    }


}
