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
public class RepairType {

    @Id
    @SequenceGenerator(name = "repairTypeGenerator", sequenceName = "repairTypeGenerator", allocationSize = 1)
    @GeneratedValue(generator = "repairTypeGenerator", strategy = GenerationType.AUTO)
    private Long repairTypeId;

    @Column(name = "repairType")
    private String repairType;
}
