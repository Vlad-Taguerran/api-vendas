package com.lvsolutions.system.dto.UserDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserPostDto(@NotBlank
                          String name,
                          @Email
                          String email, String password, String position,
                          String role) {
}
