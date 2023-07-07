package com.example.technikonproject.domain;

import com.example.technikonproject.domain.enums.RepairStatus;
import com.example.technikonproject.domain.enums.RepairType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="propertyRepairs")
@SequenceGenerator(name = "idGenerator", sequenceName = "property_repair_seq", initialValue = 1, allocationSize = 1)
public class PropertyRepair extends BaseModel{


    @NotNull
    @JsonIgnoreProperties()
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(referencedColumnName = "tin")
    private WebUser webUser;

    @NotNull
    @ManyToOne()
    @JoinColumn(referencedColumnName = "e9number")
    private Property property;

    @NotNull
    @Column
    private LocalDate dateOfScheduledRepair;

    @NotNull
    @Column(length = 250)
    private String description;

    @NotNull
    @Column
    private BigDecimal costOfRepair;

    @NotNull
    @Column
    private RepairType repairType;

    @NotNull
    @Column
    private RepairStatus repairStatus;
}
