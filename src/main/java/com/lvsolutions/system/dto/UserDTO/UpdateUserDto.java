package com.lvsolutions.system.dto.UserDTO;

import jakarta.validation.constraints.*;

public record UpdateUserDto(
        @NotBlank
        String name,
        @Email
        String emial, String password,String position) {
}
