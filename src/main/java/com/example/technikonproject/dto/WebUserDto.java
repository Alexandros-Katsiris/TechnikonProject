package com.example.technikonproject.dto;

import lombok.Data;

@Data
public class WebUserDto {

    private Long tin;

    private String firstName;

    private String Surname;

    private AddressDto address;

    private Integer phoneNumber;

    private String email;

}
