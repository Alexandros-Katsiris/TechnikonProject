package com.example.technikonproject.transfer.resource.webuser;

import com.example.technikonproject.domain.subDomain.Address;
import com.example.technikonproject.domain.subDomain.Role;
import com.example.technikonproject.transfer.resource.BaseResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class WebUserResource extends BaseResource {

    private Long tin;

    private String firstName;

    private String surname;

    private Integer phoneNumber;

    private String email;

    private Address address;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Set<Role> roles;

}