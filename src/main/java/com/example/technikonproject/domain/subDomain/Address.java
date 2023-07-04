package com.example.technikonproject.domain.subDomain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {

    public Address(String streetName, Integer streetNumber, Integer zipcode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.zipcode = zipcode;
    }

    @Id
    @SequenceGenerator(name = "addressGenerator", sequenceName = "addressGenerator", allocationSize = 1)
    @GeneratedValue(generator = "addressGenerator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private Integer streetNumber;

    @Column(nullable = false)
    private Integer zipcode;
}
