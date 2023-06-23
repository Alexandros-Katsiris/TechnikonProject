package com.example.technikonproject.Model.enums;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "propertyType")
public class PropertyType {
    @Id
    private UUID id;
    @Column
    private String propertyTypeDescription;


}
