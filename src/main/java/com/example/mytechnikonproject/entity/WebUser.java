package com.example.mytechnikonproject.entity;

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
    @Column(name="tin")
    private Long tin;
    @Column(name = "firstName",
    nullable = false)
    private String firstName;
    @Column(name = "surname",
    nullable = false)
    private String Surname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress id")
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
