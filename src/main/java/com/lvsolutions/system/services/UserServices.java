package com.lvsolutions.system.services;

import com.lvsolutions.system.dto.UserDTO.UpdateUserDto;
import com.lvsolutions.system.entity.Users;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserServices {
    public ResponseEntity<Users> createUser(Users user);

    public ResponseEntity<Users> updateUser(UpdateUserDto user, UUID id);
}
