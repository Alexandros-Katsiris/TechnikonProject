package com.example.technikonproject.controller;

import com.example.technikonproject.domain.PropertyRepair;
import com.example.technikonproject.transfer.resource.PropertyRepairResource;
import com.example.technikonproject.service.PropertyRepairService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/propertyRepair")
public class PropertyRepairController {

    private final PropertyRepairService propertyRepairService;


    public PropertyRepairController(PropertyRepairService propertyRepairService) {
        this.propertyRepairService = propertyRepairService;
    }

    @PostMapping()
    public void addPropertyRepairs(@RequestBody PropertyRepair propertyRepair) {
        propertyRepairService.create(propertyRepair);
    }

    @GetMapping(params = {"dateStart", "dateEnd"})
    public List<PropertyRepairResource> getPropertyRepairByDate(String dateStart, String dateEnd) {
        LocalDate dateStartConverted = LocalDate.parse(dateStart);
        LocalDate dateEndConverted = LocalDate.parse(dateEnd);
        return propertyRepairService.findPropertyRepairsByRangeOfDates(dateStartConverted, dateEndConverted);
    }

    // From PDF -> ::: User ID in case we want to display all the repairs made for a property owner :::
    @GetMapping(params = "id")
    public List<PropertyRepairResource> getPropertyRepairByWebUserId(Long id) {
        return propertyRepairService.findPropertyRepairsByWebUserId(id);
    }

    @GetMapping("/{id}")
    public PropertyRepairResource getPropertyRepairDto(@PathVariable Long id) throws Exception {
        return propertyRepairService.findPropertyRepair(id);
    }

    @PutMapping()
    public void updateProperty(@RequestBody PropertyRepair propertyRepair) throws Exception {
        propertyRepairService.updatePropertyRepair(propertyRepair);
    }
}
