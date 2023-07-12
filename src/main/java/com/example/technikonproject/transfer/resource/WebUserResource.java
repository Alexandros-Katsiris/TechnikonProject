package com.example.technikonproject.transfer.resource;

import com.example.technikonproject.domain.subDomain.Address;
import lombok.Data;

@Data
public class WebUserResource extends BaseResource{

    private Long tin;

    private String firstName;

    private String surname;

    private Integer phoneNumber;

    private String email;

    private Address address;

}
