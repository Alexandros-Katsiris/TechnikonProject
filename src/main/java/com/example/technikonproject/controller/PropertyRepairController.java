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

    @PostMapping("/add/prRepairs")
    public void addPropertyRepairs(@RequestBody PropertyRepair propertyRepair){
        propertyRepairService.addPropertyRepairId(propertyRepair);
    }

    @GetMapping("/get/properties/repair/date")
    public List<PropertyRepair> getPropertyRepairByDate(@RequestParam String date) throws ParseException {
            //Date dateConverted = formatter.parse(date);
            LocalDate dateConverted = LocalDate.parse(date);
            return propertyRepairService.searchPropertyRepairs(dateConverted);
    }

    @GetMapping("/get/properties/repair/id")
    public List<PropertyRepair> getPropertyRepairByDate(@RequestParam Long id) throws ParseException {
        return propertyRepairService.searchPropertyRepairsByWebUserId(id);
    }
}
