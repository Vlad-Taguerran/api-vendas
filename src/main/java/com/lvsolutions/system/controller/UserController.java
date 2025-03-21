package com.lvsolutions.system.controller;

import com.lvsolutions.system.entity.Users;
import com.lvsolutions.system.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserServices service;

    @PostMapping()
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        return service.createUser(user);
    }


}
