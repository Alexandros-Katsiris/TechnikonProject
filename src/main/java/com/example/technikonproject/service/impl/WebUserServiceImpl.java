package com.example.technikonproject.service.impl;

import com.example.technikonproject.Model.WebUser;
import com.example.technikonproject.Model.enums.Address;
import com.example.technikonproject.repository.WebUserRepository;
import com.example.technikonproject.service.AddressService;
import com.example.technikonproject.service.WebUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebUserServiceImpl implements WebUserService {
    private final WebUserRepository webUserRepository;
    private final AddressService addressService;

    public WebUserServiceImpl(WebUserRepository webUserRepository, AddressService addressService) {
        this.webUserRepository = webUserRepository;
        this.addressService = addressService;
    }


    @Override
    public void addWebUser(WebUser webUser) {
        webUserRepository.save(webUser);
    }

    @Override
    public WebUser readWebUser(Long tin) {
        //return webUserRepository.readWebUserByTin(tin);
        return webUserRepository.findById(tin).orElseThrow();
        //return webUser;
    }

    public List<WebUser> readWebUserByFirstName(String name) {
        return webUserRepository.readWebUserByFirstName(name);
    }

    @Override
    public WebUser readWebUserByEmail(String email) {
        return webUserRepository.readWebUserByEmail(email);
    }

//    @Override
//    public List<WebUser> searchWebUser(Long tin, String email, String name) {
//        return webUserRepository.findById(tin).stream().toList();
//    }

    @Override
    public void updateWebUser(Long tin, String email, String password, String name) throws Exception {
        if(!(email.isEmpty())){
            updateUserEmailNew(tin,email);
        }
        if(!(password.isEmpty())){
            updateUserPassword(tin,password);
        }
        if (!(name.isEmpty())){
            updateUserName(tin,name);
        }

//
//        WebUser webUserOld = webUserRepository.findById(tin).orElseThrow(
//                () -> new RuntimeException("owner with id -> %s does not exist".formatted(tin)));
//
//        webUserOld.setAddress(updateUserAddress(webUserNew));
//        webUserOld.setEmail(updateUserEmail(webUserNew, webUserOld));
//        webUserOld.setPassword(updateUserPassword(webUserOld, webUserNew));
//        webUserOld.setFirstName(updateUserName(webUserNew, webUserOld));
//        webUserRepository.save(webUserOld);
    }

    public void updateUserEmailNew(Long tin, String email){
        WebUser webUser = webUserRepository.findById(tin).orElseThrow(
                () -> new RuntimeException("Owner doesnt exist".formatted(tin)));
        webUser.setEmail(email);
        webUserRepository.save(webUser);
    }

    public void updateUserPassword(Long tin, String password){
        WebUser webUser = webUserRepository.findById(tin).orElseThrow(
                () -> new RuntimeException("Owner Doesnt Exist".formatted(tin)));
        webUser.setPassword(password);
        webUserRepository.save(webUser);
    }


    public void updateUserName(Long tin, String name) throws Exception {
        WebUser webUser = webUserRepository.findById(tin).orElseThrow(
                () -> new RuntimeException("Owner Doesnt Exist".formatted(tin)));
        webUser.setUsername(name);
        webUserRepository.save(webUser);
    }


    private String updateUserName(WebUser webUserNew, WebUser webUserOld) {
        if (!webUserNew.getFirstName().isEmpty()) {
            //webUserOld.setFirstName(webUserNew.getFirstName());
            return webUserNew.getFirstName();
        }
        return webUserOld.getFirstName();
    }

    private String updateUserPassword(WebUser webUserOld, WebUser webUserNew) {
        if (!webUserNew.getPassword().isEmpty())
            return webUserNew.getPassword();
        return webUserOld.getPassword();
    }

    private String updateUserEmail(WebUser webUserNew, WebUser webUserOld) {
        if (!webUserNew.getEmail().isEmpty()) {
            return webUserNew.getEmail();
        }
        return webUserOld.getEmail();

    }

    private Address updateUserAddress(WebUser webUserNew) {
        Address address = webUserNew.getAddress();

        int c =0;
        if (!webUserNew.getAddress().getStreetName().isEmpty()) {
            address.setStreetName(webUserNew.getAddress().getStreetName());
            c++;
        }
        if (webUserNew.getAddress().getStreetNumber() > 0) {
            address.setStreetNumber(webUserNew.getAddress().getStreetNumber());
            c++;
        }
        if (webUserNew.getAddress().getZipcode() > 0) {
            address.setZipcode(webUserNew.getAddress().getZipcode());
            c++;
        }
        if (c>0){

            //address.setAddressId(addressRepository.count()+1L);
            addressService.addAddress(address);
        }
        return address;
    }

    @Override
    public void deleteWebUser(Long tin) {
        if (webUserRepository.existsById(tin))
            webUserRepository.deleteById(tin);
        else
            System.out.println("No User Found");
    }


}
