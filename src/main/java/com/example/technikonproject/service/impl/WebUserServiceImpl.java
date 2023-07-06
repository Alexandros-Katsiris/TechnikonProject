package com.example.technikonproject.service.impl;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.domain.subDomain.Address;
import com.example.technikonproject.repository.WebUserRepository;
import com.example.technikonproject.service.AddressService;
import com.example.technikonproject.service.WebUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebUserServiceImpl extends BaseServiceImpl<WebUser> implements WebUserService {
    private final WebUserRepository webUserRepository;
    private final AddressService addressService;

    @Override
    public JpaRepository<WebUser, Long> getRepository() {
        return webUserRepository;
    }

    @Override
    public WebUser create(WebUser webUser) {
        return webUserRepository.save(webUser);
    }

    @Override
    public WebUser read(Long id) {
        return webUserRepository.findById(id).orElseThrow();
    }

    @Override
    public WebUser readWebUser(Long tin) {
        //return webUserRepository.readWebUserByTin(tin);
        return webUserRepository.readWebUserByTin(tin);
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
    public void update(WebUser webUser) {

        WebUser webUserOld = webUserRepository.findById(webUser.getId()).orElseThrow();
        webUserOld.setEmail(updateUserEmail(webUser, webUserOld));
        webUserOld.setPassword(updateUserPassword(webUser, webUserOld));
        webUserOld.setFirstName(updateUserName(webUser, webUserOld));
        webUserOld.setAddress(updateUserAddress(webUser.getAddress(), webUserOld.getAddress()));
        webUserRepository.save(webUserOld);
    }

    private String updateUserName(WebUser webUserNew, WebUser webUserOld) {
        if (!webUserNew.getFirstName().isEmpty() &&
                !webUserNew.getFirstName().equals(webUserOld.getFirstName())) {
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
        boolean updateAddress = !newAddress.getStreetName().equals(oldAddress.getStreetName()) &&
                !newAddress.getStreetName().isEmpty();
        if (!(newAddress.getStreetNumber().equals(oldAddress.getStreetNumber())) &&
                !(newAddress.getStreetNumber() == 0) &&
                !(newAddress.getStreetNumber() == null)) {
            updateAddress = true;
        }
        if (!(newAddress.getZipcode().equals(oldAddress.getZipcode())) &&
                !(newAddress.getZipcode() == 0) &&
                !(newAddress.getZipcode() == null)) {
            updateAddress = true;
        }
        //To be implemented\/

        if (updateAddress) {
            Address existingAddress = addressService.addressExist(newAddress);
            if (existingAddress == null) {
                addressService.addAddress(newAddress);
                return newAddress;
            } else {
                return existingAddress;
            }
        } else {
            return oldAddress;
        }
    }

    public void deleteByTin(Long tin) {
        WebUser webUser = webUserRepository.readWebUserByTin(tin);
        if (checkNullability(webUser)) {
            webUserRepository.deleteByTin(tin);
        }
    }

    private boolean checkNullability(WebUser webUser) {
        if (webUser == null) {
            logger.warn("WebUser does not exist.");
            return true;
        }
        return false;
    }

}
