package com.example.technikonproject.Model.Parent;


import com.example.technikonproject.Model.Kids.Address;
import com.example.technikonproject.Model.Kids.PropertyType;
import com.example.technikonproject.Model.Kids.RepairStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "property")
public class Property{

    @Id
    private Integer e9;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "id")
    private Address addressId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private PropertyType propertyType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private RepairStatus repairStatus;

    @Column
    private Date yearOfConstruction;

    //To add picture
    //To add map location
}
