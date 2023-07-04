package com.example.technikonproject.Model;

import com.example.technikonproject.Model.enums.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WebUser {

    @Id
    private Long id;
    @Column(unique = true)
    private Long tin;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String Surname;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "phoneNumber")
    private Integer phoneNumber;
    @Column(name = "email",
    nullable = false)
    private String email;
    @Column(name = "username",
    nullable = false)
    private String username;
    @Column(name = "password",
    nullable = false)
    private String password;


}
