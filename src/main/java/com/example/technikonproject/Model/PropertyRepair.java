package com.example.technikonproject.Model;

import com.example.technikonproject.Model.enums.RepairStatus;
import com.example.technikonproject.Model.enums.RepairType;
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

    @Column
    private Date dateOfScheduledRepair;

    @Column
    private String repairDescription;

    @OneToOne
    @JoinColumn(name = "repair_type_id")
    private RepairType repairType;

    @OneToOne
    @JoinColumn(name = "repair_status_id")
    private RepairStatus repairStatus;

    @Column
    private Double costOfRepair;

    @Column
    private Long webUserId;

    @Column
    private Long propertyId;

}
