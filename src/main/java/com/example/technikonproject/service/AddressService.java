package com.example.technikonproject.service;

import com.example.technikonproject.domain.subDomain.Address;

public interface AddressService extends BaseService<Address, Long> {


    Address addressExist(Address address);
    Address updateAddress(Address newAddress, Address oldAddress);
}
