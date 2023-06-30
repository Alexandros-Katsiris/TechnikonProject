package com.example.technikonproject.service.impl;

import com.example.technikonproject.Model.enums.Address;
import com.example.technikonproject.repository.AddressRepository;
import com.example.technikonproject.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void addAddress(Address address) {
        addressRepository.save(address);
    }
}
