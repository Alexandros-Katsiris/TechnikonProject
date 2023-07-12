package com.example.technikonproject.transfer.resource;

import com.example.technikonproject.domain.enums.PropertyType;
import com.example.technikonproject.domain.subDomain.Address;
import com.example.technikonproject.transfer.resource.medInfo.WebUserMedInfoResource;
import lombok.Data;

import java.util.Date;

@Data
public class PropertyResource extends BaseResource{

    private Long e9Number;

    private Address address;

    private WebUserMedInfoResource webUserMedInfoResource;

    private Date yearOfConstruction;

    private PropertyType propertyType;

    private String picture;

    private String location;
}
