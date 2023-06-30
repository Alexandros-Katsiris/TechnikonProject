package com.example.technikonproject.controller;

import com.example.technikonproject.Model.WebUser;
import com.example.technikonproject.service.WebUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    }

    @GetMapping("/name/{name}")
    public List<WebUser> readWebUserByFirstName(@PathVariable String name){
        return webUserService.readWebUserByFirstName(name);
    }

    @GetMapping("/email/{email}")
    public WebUser readWebUserByEmail(@PathVariable String email){
        return webUserService.readWebUserByEmail(email);
    }

    @PostMapping("/add")
    public void addWebUser(@RequestBody WebUser webUser){
        webUserService.addWebUser(webUser);
    }

    @PutMapping("/update/{tin}")
    public void updateWebUser(@RequestBody WebUser webUser, @PathVariable("tin") Long tinNumber) throws Exception {
        webUserService.updateWebUser(webUser,tinNumber);
    }

    @PutMapping("/updateEmail/{tin}")
    public void updateEmail(@PathVariable Long tin,@RequestParam(name = "email") String email) throws Exception{
        webUserService.updateUserEmailNew(tin,email);
    }

    @DeleteMapping("/delete/{tinNumber}")
    public void deleteWebUser(@PathVariable Long tinNumber){
        webUserService.deleteWebUser(tinNumber);
    }
}
