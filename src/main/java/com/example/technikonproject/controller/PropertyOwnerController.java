package com.example.technikonproject.controller;

import com.example.technikonproject.Model.PropertyOwner;
import com.example.technikonproject.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class PropertyOwnerController {
    private final UserService userService;

    public PropertyOwnerController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String HomePage(){
        return "This is the first page";
    }

    @GetMapping("/{id}")
    public PropertyOwner findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

}
