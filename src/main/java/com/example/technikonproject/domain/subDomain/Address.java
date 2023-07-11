package com.example.technikonproject.domain.subDomain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Address {

    private String streetName;

    private Integer streetNumber;

    private Integer zipcode;

    private Integer floorNumber;
}
