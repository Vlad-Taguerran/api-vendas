package com.lvsolutions.system.controller.auth;

import com.lvsolutions.system.dto.Auth.AuthDto;
import com.lvsolutions.system.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping
    public ResponseEntity login(@RequestBody AuthDto authDto) {
        return authService.login(authDto);
    }
}
