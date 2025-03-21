package com.lvsolutions.system.services.imp;

import com.lvsolutions.system.auth.jwt.JwtUtils;
import com.lvsolutions.system.dto.Auth.AuthDto;
import com.lvsolutions.system.entity.Users;
import com.lvsolutions.system.services.AuthService;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class AuthServiceImplement implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;
    public ResponseEntity login(AuthDto authDto) {
        try {
            Authentication _user = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authDto.email(), authDto.password())
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(authDto.email());

            String token = jwtUtils.generateToken(userDetails, (Users) _user.getPrincipal());

            return ResponseEntity.ok(Map.of("token", token));
        } catch (BadCredentialsException e) {
            log.info(e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
