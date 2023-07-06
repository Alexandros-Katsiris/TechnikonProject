package com.example.technikonproject.service.impl;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.domain.subDomain.Address;
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

    @Override
    public void updateWebUser(Long tin, String email, String password, String name) throws Exception {
        if (!(email.isEmpty())) {
            updateUserEmailNew(tin, email);
        }
        if (!(password.isEmpty())) {
            updateUserPassword(tin, password);
        }
        if (!(name.isEmpty())) {
            updateUserName(tin, name);
        }

    }

    @Override
    public void updateWebUser(WebUser webUser) throws Exception {

        WebUser webUserOld = webUserRepository.findById(webUser.getId()).orElseThrow();
        webUserOld.setEmail(updateUserEmail(webUser, webUserOld));
        webUserOld.setPassword(updateUserPassword(webUser, webUserOld));
        webUserOld.setFirstName(updateUserName(webUser, webUserOld));
        webUserOld.setAddress(updateUserAddress(webUser.getAddress(),webUserOld.getAddress()));
        webUserRepository.save(webUserOld);
    }

    private String updateUserName(WebUser webUserNew, WebUser webUserOld) {
        if (!webUserNew.getFirstName().isEmpty() &&
                !webUserNew.getFirstName().equals(webUserOld.getFirstName())) {
            //webUserOld.setFirstName(webUserNew.getFirstName());
            return webUserNew.getFirstName();
        }
        return webUserOld.getFirstName();
    }

    private String updateUserPassword(WebUser webUserOld, WebUser webUserNew) {
        if (!webUserNew.getPassword().isEmpty() &&
                !webUserNew.getPassword().equals(webUserOld.getPassword()))
            return webUserOld.getPassword();
        return webUserNew.getPassword();
    }

    private String updateUserEmail(WebUser webUserNew, WebUser webUserOld) {
        if (!webUserNew.getEmail().isEmpty() &&
                !webUserNew.getEmail().equals(webUserOld.getEmail())) {
            return webUserNew.getEmail();
        }
        return webUserOld.getEmail();

    }

    private Address updateUserAddress(Address newAddress, Address oldAddress) {
        boolean updateAddress = false;
        if (!newAddress.getStreetName().equals(oldAddress.getStreetName()) &&
            !newAddress.getStreetName().isEmpty()){
            updateAddress = true;
        }
        if (!(newAddress.getStreetNumber().equals(oldAddress.getStreetNumber())) &&
            !(newAddress.getStreetNumber() == 0) &&
            !(newAddress.getStreetNumber() == null)){
            updateAddress = true;
        }
        if(!(newAddress.getZipcode().equals(oldAddress.getZipcode())) &&
            !(newAddress.getZipcode() == 0) &&
            !(newAddress.getZipcode() == null)){
            updateAddress = true;
        }
        //To be implemented\/

        if (updateAddress) {
            Address existingAddress = addressService.addressExist(newAddress);
            if(existingAddress==null){
                addressService.addAddress(newAddress);
                return newAddress;
            }else{
                return existingAddress;
            }
        }else{
            return oldAddress;
        }
    }

    @Override
    public void deleteWebUser(Long tin) {
        if (webUserRepository.existsById(tin))
            webUserRepository.deleteById(tin);
        else
            System.out.println("No User Found");
    }


}
