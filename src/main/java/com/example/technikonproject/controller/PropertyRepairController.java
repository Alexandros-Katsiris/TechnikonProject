package com.example.technikonproject.controller;

import com.example.technikonproject.domain.PropertyRepair;
import com.example.technikonproject.service.PropertyRepairService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/propertyRepair")
public class PropertyRepairController {

    //private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private final PropertyRepairService propertyRepairService;

    public PropertyRepairController(PropertyRepairService propertyRepairService) {
        this.propertyRepairService = propertyRepairService;
    }

    //Not working correctly
    @PostMapping("/add/prRepairs")
    public void addPropertyRepairs(@RequestBody PropertyRepair propertyRepair){
        propertyRepairService.addPropertyRepairId(propertyRepair);
    }

    @GetMapping("/get/properties/repair/date")
    public List<PropertyRepair> getPropertyRepairByDate(@RequestParam String dateStart, @RequestParam String dateEnd) throws ParseException {
            LocalDate dateStartConverted = LocalDate.parse(dateStart);
            LocalDate dateEndConverted = LocalDate.parse(dateEnd);
            return propertyRepairService.findPropertyRepairsByRangeOfDates(dateStartConverted, dateEndConverted);
    }

    @GetMapping("/get/properties/repair/id")
    public List<PropertyRepair> getPropertyRepairByDate(@RequestParam Long id) throws ParseException {
        return propertyRepairService.findPropertyRepairsByWebUserId(id);
    }

    @PutMapping("/update")
    public void updateProperty(@RequestBody PropertyRepair propertyRepair) throws Exception{
        propertyRepairService.updatePropertyRepair(propertyRepair);
    }
}
