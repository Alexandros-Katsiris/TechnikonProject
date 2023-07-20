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
@Table(name = "webUsers")
@SequenceGenerator(name = "idGenerator", sequenceName = "web_user_seq", allocationSize = 1)
public class WebUser extends BaseModel {

    @Column(unique = true, updatable = false)
    private Long tin;

    @Column(length = 50, nullable = false, updatable = false)
    private String firstName;

    @Column(length = 50, nullable = false, updatable = false)
    private String surname;

    @Embedded
    private Address address;

    @Column(nullable = false, updatable = false)
    private Long phoneNumber;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 20, unique = true, updatable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
}
