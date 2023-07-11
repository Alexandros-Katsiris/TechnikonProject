package com.example.technikonproject.repository;

import com.example.technikonproject.domain.subDomain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAddressByStreetNameAndStreetNumberAndZipcodeAndFloorNumber(String name, Integer number, Integer zipCode,Integer floorNumber);

//    Address findAddressById(Long id);
}
