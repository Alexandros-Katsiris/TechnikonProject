package com.example.technikonproject.controller;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.dto.WebUserDto;
import com.example.technikonproject.mapper.MapStructMapper;
import com.example.technikonproject.service.WebUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class WebUserController {
    private final WebUserService webUserService;

    public WebUserController(WebUserService webUserService, MapStructMapper mapStructMapper) {
        this.webUserService = webUserService;
    }

    @PostMapping()
    public void add(@RequestBody WebUser webUser) {
        webUserService.create(webUser);
    }

    @GetMapping("/{id}")
    public WebUserDto readDto(@RequestParam(name = "id") Long id) {
        return webUserService.readDto(id);
    }


    @GetMapping(params = "tin")
    public WebUser readByTIn(@RequestParam(name = "tin") Long tin) {
        return webUserService.readWebUser(tin);
    }

    @GetMapping(params = "username")
    public List<WebUser> readByFirstName(@PathVariable String name) {
        return webUserService.readWebUserByFirstName(name);
    }

    @GetMapping(params = "email")
    public WebUser readByEmail(@PathVariable String email) {
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
    public void deleteByTin(@PathVariable Long tin) {
        webUserService.deleteByTin(tin);
    }

}
