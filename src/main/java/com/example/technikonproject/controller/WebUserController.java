package com.example.technikonproject.controller;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.mapper.BaseMapper;
import com.example.technikonproject.mapper.WebUserMapper;
import com.example.technikonproject.service.BaseService;
import com.example.technikonproject.service.WebUserService;
import com.example.technikonproject.transfer.ApiResponse;
import com.example.technikonproject.transfer.resource.WebUserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class WebUserController extends BaseController<WebUser, WebUserResource> {

    private final WebUserService webUserService;

    private final WebUserMapper webUserMapper;

    @Override
    public BaseService<WebUser, Long> getBaseService() {
        return webUserService;
    }

    @Override
    protected BaseMapper<WebUser, WebUserResource> getMapper() {
        return webUserMapper;
    }

    @GetMapping(params = {"email"})
    public ResponseEntity<ApiResponse<WebUserResource>> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(
                ApiResponse.<WebUserResource>builder().data(getMapper().toResource(webUserService.readWebUserByEmail(email)))
                        .build());
    }

    @GetMapping(params = {"tin"})
    public ResponseEntity<ApiResponse<WebUserResource>> findByTin(@RequestParam Long tin) {
        return ResponseEntity.ok(
                ApiResponse.<WebUserResource>builder().data(getMapper().toResource(webUserService.readWebUser(tin)))
                        .build());
    }

//    @PutMapping()
//    public ResponseEntity<ApiResponse<WebUserResource>> update(@RequestBody WebUser webUser) {
//        return ResponseEntity.ok(
//                ApiResponse.<WebUserResource>builder().data(getMapper().toResource(webUserService.update(webUser)))
//                        .build());
//
//    }

    @GetMapping(params = {"firstName"})
    public ResponseEntity<ApiResponse<List<WebUserResource>>> findByFirstName(@RequestParam String firstName) {
        return ResponseEntity.ok(
                ApiResponse.<List<WebUserResource>>builder().data(getMapper().toResources(webUserService.readWebUserByFirstName(firstName)))
                        .build());

    }

}
