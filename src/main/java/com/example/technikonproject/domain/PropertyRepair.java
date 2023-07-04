package com.example.technikonproject.domain;

import com.example.technikonproject.domain.subDomain.RepairStatus;
import com.example.technikonproject.domain.subDomain.RepairType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PropertyRepair {

    @Id
    @SequenceGenerator(name = "propertyRepairGenerator", sequenceName = "propertyRepairGenerator", allocationSize = 1)
    @GeneratedValue(generator = "propertyRepairGenerator", strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private LocalDate dateOfScheduledRepair;

    @Column
    private Double costOfRepair;

    @ManyToOne
    private RepairType repairType;

    @ManyToOne
    private RepairStatus repairStatus;


    @ManyToOne
    private WebUser webUser;

    @ManyToOne
    private Property property;

}
