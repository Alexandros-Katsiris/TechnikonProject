package com.example.technikonproject.domain.subDomain;

import com.example.technikonproject.domain.BaseModel;
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
@Table(name="propertyTypes")
@SequenceGenerator(name = "idGenerator", sequenceName = "property_type_seq", initialValue = 1, allocationSize = 1)
public class PropertyType extends BaseModel {

    @Column
    private String propertyType;
}
