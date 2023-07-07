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
@Table(name="webUsers")
@SequenceGenerator(name = "idGenerator", sequenceName = "web_user_seq", initialValue = 1, allocationSize = 1)
public class WebUser extends BaseModel{

    @Column(unique = true, updatable = false)
    private Long tin;

    @Column(length = 50, nullable = false,updatable = false)
    private String firstName;

    @Column(length = 50, nullable = false, updatable = false)
    private String surname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false,unique = true)
    private Address address;

    @Column(nullable = false,updatable = false)
    private Integer phoneNumber;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 20, nullable = false, unique = true,updatable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,updatable = false)
    private boolean isAdmin;
}
