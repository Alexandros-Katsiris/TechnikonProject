package com.example.mytechnikonproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PropertyRepair {

    @Id
    @SequenceGenerator(name = "propertyRepairGenerator", sequenceName = "propertyRepairGenerator", allocationSize = 1)
    @GeneratedValue(generator = "propertyRepairGenerator", strategy = GenerationType.AUTO)
    private Long propertyRepairId;

    @Column(name = "dateOfScheduledRepair")
    private Date dateOfScheduledRepair;

    @Column(name = "repairDescription")
    private String repairDescription;

    @OneToOne
    @JoinColumn(name = "repairTypeId")
    private RepairType repairType;

    @OneToOne
    @JoinColumn(name = "repairStatusId")
    private RepairStatus repairStatus;

    @Column(name = "costOfRepair")
    private Double costOfRepair;

    @Column(name = "webUserId")
    private Long webUserId;

    @Column(name = "propertyId")
    private Long propertyId;

}
