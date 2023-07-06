package com.example.technikonproject.domain.subDomain;

import com.example.technikonproject.domain.BaseModel;
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
@Table(name="addresses",uniqueConstraints = {@UniqueConstraint(name = "UniqueAddressAndNumberAndFloorNumber", columnNames = {"streetname","streetnumber","floornumber"})})
@SequenceGenerator(name = "idGenerator", sequenceName = "address_seq", initialValue = 1, allocationSize = 1)
public class Address extends BaseModel {


    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private Integer streetNumber;

    @Column(nullable = false)
    private Integer zipcode;

    @Column()
    private Integer floorNumber;
}
