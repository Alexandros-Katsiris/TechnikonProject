package com.example.technikonproject.Model.enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PropertyType {

    public PropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Id
    @SequenceGenerator(name = "propertyTypeIdGenerator", sequenceName = "propertyTypeIdGenerator", allocationSize = 1)
    @GeneratedValue(generator = "propertyTypeGenerator", strategy = GenerationType.AUTO)
    private Long propertyTypeId;

    @Column
    private String propertyType;
}
