package com.example.technikonproject.Model.enums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    @Id
    @Column(name="id")
    private Long addressId;

    @Column(name = "street_name",
    nullable = false)
    private String streetName;

    @Column(name = "street_number",
    nullable = false)
    private Integer streetNumber;

    @Column(name = "zipcode")
    private Integer zipcode;
}
