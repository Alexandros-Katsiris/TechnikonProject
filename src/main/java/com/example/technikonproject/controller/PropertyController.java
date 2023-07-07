package com.example.technikonproject.controller;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.dto.PropertyDto;
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

    @PostMapping("/addProperty")
    public void addProperty(@RequestBody Property property) {
        propertyService.create(property);
    }

    // Search Properties. Search by e9 -> admin/user, search by tin number -> admin only
    @GetMapping("/getByE9/{e9Number}")
    public PropertyDto readPropertyDto(@PathVariable Long e9Number){
        return propertyService.readPropertyDto(e9Number);
    }

    @GetMapping("/getByTin/{tin}")
    public List<Property> readPropertiesByTin(@PathVariable Long tin) {
        return propertyService.findPropertiesByTin(tin);
    }

    @GetMapping("/getById")
    public Property read(@RequestParam(name = "id") Long id) {
        return propertyService.read(id);
    }

    @PutMapping("/updateProperty")
    public void updateProperty(@RequestBody Property property) {
        propertyService.update(property);
    }

    @DeleteMapping("/delete/{e9Number}")
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deleteById(id);
    }
}
