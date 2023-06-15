package com.example.technikonproject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {
    @GetMapping
    public String HomePage(){
        return "This is the first page";
    }

    @GetMapping("/Hello")
    public String showThis() {
        return "Hello World";
    }
    @GetMapping("/Bye")
    public String showThat(){
        return "Bye bye World"
    }
}
