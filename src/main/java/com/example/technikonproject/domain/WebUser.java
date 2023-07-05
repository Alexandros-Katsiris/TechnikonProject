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
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isAdmin;
}
