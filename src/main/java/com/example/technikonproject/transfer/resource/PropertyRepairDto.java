package com.example.technikonproject.transfer.resource;

import com.example.technikonproject.domain.enums.RepairStatus;
import com.example.technikonproject.domain.enums.RepairType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PropertyRepairDto {

    private String description;

    private RepairType repairType;

    private RepairStatus repairStatus;

    private BigDecimal costOfRepair;

    private WebUserForRepairDto webUser;

    private PropertyForRepairDto property;

}
