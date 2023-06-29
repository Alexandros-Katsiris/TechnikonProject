package com.example.technikonproject.Model;

import com.example.technikonproject.Model.enums.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Property {

    @Id
    @Column
    private Long e9Number;

    @Column
    private Date yearOfConstruction;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne()
    @JoinColumn(name = "tin_number")
    private WebUser webUser;

    @Column
    private String picture;

    @Column
    private String location;

    @OneToOne
    @JoinColumn(name = "property_repair_id")
    private PropertyRepair propertyRepairId;
}
