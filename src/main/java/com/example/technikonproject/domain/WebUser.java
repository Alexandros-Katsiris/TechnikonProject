package com.example.technikonproject.domain;

import com.example.technikonproject.domain.subDomain.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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

    public WebUser(Long tin, String firstName, String surname, Address address, Integer phoneNumber, String email, String username, String password, boolean isAdmin) {
        this.tin = tin;
        this.firstName = firstName;
        Surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    @Id
    @SequenceGenerator(name = "userGenerator", sequenceName = "userGenerator", allocationSize = 1)
    @GeneratedValue(generator = "userGenerator", strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private Long tin;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String Surname;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Address address;
    @Column(nullable = false)
    private Integer phoneNumber;
    @Email
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean isAdmin;
}
