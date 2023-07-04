package com.example.technikonproject.Model;

import com.example.technikonproject.Model.enums.Address;
import com.example.technikonproject.Model.enums.PropertyType;
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
    private Long id;

    @Column(unique = true)
    private Long e9Number;

    @Column
    private Date yearOfConstruction;

    @ManyToOne
    @JoinColumn
    private Address address;

    @ManyToOne
    @JoinColumn
    private PropertyType propertyType;

    @ManyToOne()
    private WebUser webUser;

    @Column
    private String picture;

    @Column
    private String location;

}
