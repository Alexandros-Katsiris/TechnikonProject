package com.example.technikonproject.service;

import com.example.technikonproject.domain.subDomain.Address;

public interface AddressService extends BaseService<Address, Long> {

    //    Address addAddress(Address address);
//    Address findAddressById(Long id);
    Address addressExist(Address address);
}
