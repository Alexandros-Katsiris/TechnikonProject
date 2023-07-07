package com.example.technikonproject.dto;

import lombok.Data;

@Data
public class AddressDto {

    private String streetName;

    private Integer streetNumber;

    private Integer zipcode;

    private Integer floorNumber;
}
