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
public class RepairStatus {

    @Id
    @SequenceGenerator(name = "repairStatusGenerator", sequenceName = "repairStatusGenerator", allocationSize = 1)
    @GeneratedValue(generator = "repairStatusGenerator", strategy = GenerationType.AUTO)
    private Long repairStatusId;

    @Column(name = "repairStatus")
    private String repairStatus;
}
