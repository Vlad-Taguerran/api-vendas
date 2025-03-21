package com.lvsolutions.system.controller;

import com.lvsolutions.system.dto.ContactDto.ContactDto;
import com.lvsolutions.system.services.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/contact")
public class ContactController {
@Autowired
private ContactService contactService;

@PostMapping("/{customerId}")
    public ResponseEntity<ContactDto> createContact(@RequestBody @Valid ContactDto  contactDto, @PathVariable UUID customerId){
    ContactDto response = contactService.addContact(contactDto,customerId);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
