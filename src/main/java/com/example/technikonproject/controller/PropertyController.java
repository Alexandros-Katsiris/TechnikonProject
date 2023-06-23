package com.example.technikonproject.controller;

import com.example.technikonproject.Model.Property;
import com.example.technikonproject.service.PropertyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }
    @GetMapping(value = "/{id}")
    public Property findById(@PathVariable("id") Integer id){
        return propertyService.findById(id);
    }
}
