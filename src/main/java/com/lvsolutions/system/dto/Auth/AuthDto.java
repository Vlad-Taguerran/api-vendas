package com.lvsolutions.system.dto.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthDto(
        @Email
        String email,
        @NotBlank
        String password) {
}
