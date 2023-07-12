package com.example.technikonproject.transfer.resource;

import com.example.technikonproject.domain.enums.RepairStatus;
import com.example.technikonproject.domain.enums.RepairType;
import com.example.technikonproject.transfer.resource.medInfo.PropertyMedInfoResource;
import com.example.technikonproject.transfer.resource.medInfo.WebUserMedInfoResource;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PropertyRepairResource extends BaseResource {

    private WebUserMedInfoResource webUserMedInfoResource;

    private PropertyMedInfoResource propertyMedInfoResource;

    private String description;

    private LocalDate dateOfScheduledRepair;

    private RepairType repairType;

    private RepairStatus repairStatus;

    private BigDecimal costOfRepair;


}
