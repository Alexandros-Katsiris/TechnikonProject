package com.example.mytechnikonproject.entity;

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
    @Column(name="addressId")
    private Long addressId;

    @Column(name = "streetName",
    nullable = false)
    private String streetName;

    @Column(name = "streetNumber",
    nullable = false)
    private Integer streetNumber;

    @Column(name = "zipcode")
    private Integer zipcode;
}
