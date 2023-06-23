package com.example.technikonproject.Model;

import com.example.technikonproject.Model.enums.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

    @Id
    private String tin;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id")
    private Address addressId;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private boolean isAdmin;





}
