package com.lvsolutions.system.services;

import com.lvsolutions.system.dto.Auth.AuthDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    public ResponseEntity login(AuthDto authDto);
}
