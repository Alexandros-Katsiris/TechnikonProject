package com.example.technikonproject.service.impl;

import com.example.technikonproject.domain.subDomain.Address;
import com.example.technikonproject.repository.AddressRepository;
import com.example.technikonproject.service.AddressService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends BaseServiceImpl<Address>
        implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

//    @Override
//    public Address addAddress(Address address) {
//        return addressRepository.save(address);
//    }

//    @Override
//    public Address findAddressById(Long id) {
//        return addressRepository.findAddressById(id);
//    }

    @Override
    public Address addressExist(Address address) {
        List<Address> addresses = addressRepository.findAddressByStreetNameAndStreetNumberAndZipcode(address.getStreetName(), address.getStreetNumber(), address.getZipcode());
        if (addresses.size() == 0) {
            return null;
        } else {
            return addresses.get(addresses.size() - 1);
        }
    }
}
