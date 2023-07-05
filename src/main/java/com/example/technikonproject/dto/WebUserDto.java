package com.example.technikonproject.dto;

import com.example.technikonproject.domain.subDomain.Address;
import lombok.Data;

@Data
public class WebUserDto {

    private Long tin;

    private String firstName;

    private String Surname;

    private Address address;

    private Integer phoneNumber;

    private String email;

}
