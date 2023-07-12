package com.example.technikonproject.transfer.resource;

import com.example.technikonproject.domain.enums.PropertyType;
import lombok.Data;

import java.util.Date;

@Data
public class PropertyDto {

    private Long e9Number;

    private Date yearOfConstruction;

    private PropertyType propertyType;

    private String picture;

    private String location;
}
