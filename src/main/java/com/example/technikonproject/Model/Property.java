package com.example.technikonproject.Model;


import com.example.technikonproject.Model.enums.Address;
import com.example.technikonproject.Model.enums.PropertyType;
import com.example.technikonproject.Model.enums.RepairStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "property")
public class Property{

    @Id
    @Column(name = "id")
    private Integer e9;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address addressId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_type", referencedColumnName = "id")
    private PropertyType propertyType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "repair_status", referencedColumnName = "id")
    private RepairStatus repairStatus;

    @Column
    private Integer yearOfConstruction;


    //To add picture
    //To add map location
}
