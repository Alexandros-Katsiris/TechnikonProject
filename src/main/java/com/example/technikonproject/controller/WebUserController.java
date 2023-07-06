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

    @PostMapping("/add")
    public void addWebUser(@RequestBody WebUser webUser) {
        webUserService.create(webUser);
    }

    @GetMapping("/id")
    public WebUser read(@RequestParam(name = "id") Long id) {
        return webUserService.read(id);
    }

    @GetMapping("/tin")
    public WebUser readWebUser(@RequestParam(name = "tin") Long tin) {
        return webUserService.readWebUser(tin);
    }

    @GetMapping("/name/{name}")
    public List<WebUser> readWebUserByFirstName(@PathVariable String name) {
        return webUserService.readWebUserByFirstName(name);
    }

    @GetMapping("/email/{email}")
    public WebUser readWebUserByEmail(@PathVariable String email) {
        return webUserService.readWebUserByEmail(email);
    }

    @PutMapping("/updateUser/{tin}")
    public void updateUser(@PathVariable("tin") Long tin,
                           @RequestBody WebUser webUser
    ) throws Exception {
        webUserService.update(webUser);
    }

    @DeleteMapping("/deleteId/{id}")
    public void delete(@PathVariable Long id) {
        webUserService.deleteById(id);
    }

    @DeleteMapping("/delete/{tin}")
    public void deleteByTin(@PathVariable Long tin) {
        webUserService.deleteByTin(tin);
    }

}
