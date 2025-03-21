package com.lvsolutions.system.services.imp;

import com.lvsolutions.system.dto.UserDTO.UpdateUserDto;
import com.lvsolutions.system.entity.Users;
import com.lvsolutions.system.repository.UserRepository;
import com.lvsolutions.system.services.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImplement implements UserServices {
    @Autowired
    private UserRepository repository;


    public ResponseEntity<Users> createUser(Users user) {
        log.info("Creating user: {}", user);
        String password = user.getPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String _password = bCryptPasswordEncoder.encode(password);
        user.setPassword(_password);
       Users _user = repository.save(user);
       return ResponseEntity.ok(_user);
    }

    public ResponseEntity<Users> updateUser(UpdateUserDto user, UUID id) {
        Users _user = repository.findById(id).orElseThrow(()-> new ResolutionException("User not found"));
        BeanUtils.copyProperties(user, _user);
            repository.save(_user);
            return ResponseEntity.ok(_user);
    }
}
