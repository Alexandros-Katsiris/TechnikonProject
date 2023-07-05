package com.example.technikonproject.controller;

import com.example.technikonproject.domain.WebUser;
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

    // Search User Methods
//    @GetMapping("/{tinNumber}")
//    public WebUser readWebUser(@PathVariable Long tinNumber){
//        return webUserService.readWebUser(tinNumber);
//    }
    @GetMapping("/")
    public WebUser readWebUser(@RequestParam(name ="tin") Long tin){
        return webUserService.readWebUser(tin);
    }

    @GetMapping("/name/")
    public List<WebUser> readWebUserByFirstName(@RequestParam(name ="name") String name){
        return webUserService.readWebUserByFirstName(name);
    }

    @GetMapping("/email/")
    public WebUser readWebUserByEmail(@RequestParam String email){
        return webUserService.readWebUserByEmail(email);
    }

    @PostMapping("/add")
    public void addWebUser(@RequestBody WebUser webUser){
        webUserService.addWebUser(webUser);
    }

    // Update User Methods
//    @PutMapping("/update/{tin}")
//    public void updateWebUser(@RequestBody WebUser webUser, @PathVariable("tin") Long tinNumber) throws Exception {
//        webUserService.updateWebUser(webUser,tinNumber);
//    }

    @PutMapping("/updateUser/{tin}")
    public void updateUser(@RequestBody WebUser webUser)
            throws Exception{
        webUserService.updateWebUser(webUser);
    }

    @DeleteMapping("/delete/{tinNumber}")
    public void deleteWebUser(@PathVariable Long tinNumber){
        webUserService.deleteWebUser(tinNumber);
    }
}
