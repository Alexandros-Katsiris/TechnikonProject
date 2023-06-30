package com.example.technikonproject.repository;

import com.example.technikonproject.Model.enums.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {


//    @Query(value="select max(Address.addressId) from Address")
//    Long getMaxAddressId();
}
