package com.example.technikonproject.service.impl;

import com.example.technikonproject.domain.subDomain.Address;
import com.example.technikonproject.repository.AddressRepository;
import com.example.technikonproject.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findAddressById(Long id) {
        return addressRepository.findAddressById(id);
    }

    @Override
    public Address addressExist(Address address) {
        List<Address> addresses = addressRepository.findAddressByStreetNameAndStreetNumberAndZipcodeAndFloorNumber(address.getStreetName(),address.getStreetNumber(),address.getZipcode(), address.getFloorNumber());
        if(addresses.size()==0){
            return null;
        }else{
            return addresses.get(addresses.size()-1);
        }
    }

    public Address updateAddress(Address newAddress, Address oldAddress) {
        boolean updateAddress = false;
        if (!(newAddress.getStreetName().equals(oldAddress.getStreetName())) &&
                !(newAddress.getStreetName().isEmpty())) {
            updateAddress = true;
        }
        if (!(newAddress.getStreetNumber().equals(oldAddress.getStreetNumber())) &&
                !(newAddress.getStreetNumber() == 0)) {
            updateAddress = true;
        }
        if (!(newAddress.getZipcode().equals(oldAddress.getZipcode())) &&
                !(newAddress.getZipcode() == 0)) {
            updateAddress = true;
        }
        if (!(newAddress.getFloorNumber().equals(oldAddress.getFloorNumber())) &&
                !(newAddress.getFloorNumber() == 0)) {
            updateAddress = true;
        }


        if (updateAddress) {
            Address existingAddress = addressExist(newAddress);
            if (existingAddress == null) {
                addAddress(newAddress);
                return newAddress;
            } else {
                return existingAddress;
            }
        } else {
            return oldAddress;
        }
    }
}
