package com.example.technikonproject.controller;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.transfer.resource.PropertyResource;
import com.example.technikonproject.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping()
    public void addProperty(@RequestBody Property property) {
        propertyService.create(property);
    }

    // Search Properties. Search by e9 -> admin/user, search by tin number -> admin only
    @GetMapping(params = "e9Number")
    public PropertyResource readPropertyDto(Long e9Number) {
        return propertyService.readPropertyDto(e9Number);
    }

    @GetMapping(params = "tin")
    public List<Property> readPropertiesByTin(Long tin) {
        return propertyService.findPropertiesByTin(tin);
    }

    @GetMapping("/{id}")
    public Property read(@PathVariable Long id) {
        return propertyService.read(id);
    }

    @PutMapping()
    public void updateProperty(@RequestBody Property property) {
        propertyService.update(property);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deleteById(id);
    }
}
