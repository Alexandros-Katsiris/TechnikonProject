package com.example.technikonproject.controller;

import com.example.technikonproject.Model.WebUser;
import com.example.technikonproject.service.webUser.WebUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class WebUserController {
    private final WebUserService webUserService;

    public WebUserController(WebUserService webUserService) {
        this.webUserService = webUserService;
    }

    // Develop -> remove all hard copy elements and variables
    // Develop -> Search also with email and name

    @GetMapping("/{tinNumber}")
    public WebUser readWebUser(@PathVariable Long tinNumber){
        return webUserService.readWebUser(tinNumber);
        //return webUser;
    }

    @PostMapping("/add")
    public void addWebUser(@RequestBody WebUser webUser){
        webUserService.addWebUser(webUser);
    }

    @PutMapping("/update/{tinNumber}")
    public void updateWebUser(@RequestBody WebUser webUser, @PathVariable Long tin) throws Exception {
        webUserService.updateWebUser(webUser,tin);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWebUser(@PathVariable Long tin){
        webUserService.deleteWebUser(tin);
    }
}
