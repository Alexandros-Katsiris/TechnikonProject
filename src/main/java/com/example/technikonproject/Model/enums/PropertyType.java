package com.example.technikonproject.Model.enums;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "propertyType")
public class PropertyType {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column
    private String propertyTypeDescription;


}
