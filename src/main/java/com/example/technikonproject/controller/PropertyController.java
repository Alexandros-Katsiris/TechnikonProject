package com.example.technikonproject.controller;

import com.example.technikonproject.Model.Property;
import com.example.technikonproject.service.property.PropertyService;
import org.springframework.web.bind.annotation.*;

@RestController("/property")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/{e9Number}")
    public Property readProperty(@PathVariable Long e9Number){
        return propertyService.readProperty(e9Number);
    }

    @PostMapping("/addProperty")
    public void addProperty(@RequestBody Property property){
        propertyService.addNewProperty(property);
    }

    @PutMapping("/updateProperty/{e9Number}")
    public void updateProperty(@RequestBody Property property, @PathVariable Long e9Number){
        propertyService.update(property, e9Number);
    }

    @DeleteMapping("/delete/{e9Number}")
    public void deleteProperty(@PathVariable Long e9Number){
        propertyService.deleteProperty(e9Number);
    }
}
