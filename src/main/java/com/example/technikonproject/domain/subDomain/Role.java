package com.example.technikonproject.domain.subDomain;


import com.example.technikonproject.domain.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
@SequenceGenerator(name = "idGenerator", sequenceName = "roles_seq", allocationSize = 1)
public class Role extends BaseModel {

    private String role;
}
