package com.lvsolutions.system.dto.ContactDto;

import com.lvsolutions.system.entity.Contacts;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;


public record ContactDto(UUID id, @NotBlank(message = "Nome requerido") String name, String first_phone, String second_phone, @Email(message = "Email invalido") String email, String position, String anotation) {
    public ContactDto(Contacts contact) {
        this(
                contact.getId(),
                contact.getName(),
                contact.getEmail(),
                contact.getFirst_phone(),
                contact.getSecond_phone(),
                contact.getPosition(),
                contact.getAnotation()
        );
    }
}
