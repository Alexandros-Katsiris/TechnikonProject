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
    @Column(name = "e9Number")
    private Long e9Number;

    @Column(name = "yearOfConstruction")
    private Date yearOfConstruction;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;

    @ManyToOne()
    @JoinColumn(name = "tinNumber")
    private WebUser webUser;

    @Column(name = "picture")
    private String picture;

    @Column(name = "location")
    private String location;
}
