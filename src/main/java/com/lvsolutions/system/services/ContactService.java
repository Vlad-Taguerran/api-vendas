package com.lvsolutions.system.services;

import com.lvsolutions.system.dto.ContactDto.ContactDto;
import com.lvsolutions.system.entity.Contacts;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ContactService {
    public ContactDto addContact(ContactDto dto, UUID customerId);

    public ResponseEntity<Contacts> updateContact(ContactDto dto, UUID id);

    public ResponseEntity<String> deleteContact(UUID id);

    public ResponseEntity<Contacts> getContact(UUID id);

    public ResponseEntity<List<Contacts>> getAllContacts();
}
