package com.example.technikonproject.controller;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.dto.WebUserDto;
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

    @PostMapping()
    public void add(@RequestBody WebUser webUser) {
        webUserService.create(webUser);
    }

    @GetMapping("/{id}")
    public WebUserDto readDto(@PathVariable(name = "id") Long id) {
        return webUserService.readDto(id);
    }

    @GetMapping(params = "tin")
    public WebUserDto readByTin(Long tin) {
        return webUserService.readWebUser(tin);
    }

    @GetMapping(params = "username")
    public List<WebUserDto> readByFirstName(String name) {
        return webUserService.readWebUserByFirstName(name);
    }

    @GetMapping(params = "email")
    public WebUserDto readByEmail(String email) {
        return webUserService.readWebUserByEmail(email);
    }

    @PutMapping()
    public void update(@RequestBody WebUser webUser
    ) throws Exception {
        webUserService.update(webUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        webUserService.deleteById(id);
    }

    @DeleteMapping(params = "tin")
    public void deleteByTin(Long tin) {
        webUserService.deleteByTin(tin);
    }

}
