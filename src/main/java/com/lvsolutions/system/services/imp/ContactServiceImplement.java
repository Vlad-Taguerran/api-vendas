package com.lvsolutions.system.services.imp;

import com.lvsolutions.system.controllerAdvice.DuplicateExeption;
import com.lvsolutions.system.controllerAdvice.ResourceNotFoundException;
import com.lvsolutions.system.dto.ContactDto.ContactDto;
import com.lvsolutions.system.entity.Contacts;
import com.lvsolutions.system.entity.Customers;
import com.lvsolutions.system.repository.ContactRepository;
import com.lvsolutions.system.repository.CustomersRepository;
import com.lvsolutions.system.services.ContactService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ContactServiceImplement implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private CustomersRepository customersRepository;
    @Override
    @Transactional
    public ContactDto addContact(ContactDto dto,UUID customerId ) {
       try {
           Customers customer = customersRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer not found"));
           Contacts contact = new Contacts();

           BeanUtils.copyProperties(dto, contact);
           contact.setCustomer(customer);
           if(contactRepository.existsByEmail(dto.email())){
               throw new DuplicateExeption("Email already exists");
           }
           Contacts _contact = contactRepository.save(contact);
           customer.getContacts().add(_contact);


           return new ContactDto(_contact);
       } catch (DuplicateKeyException e) {
           throw new RuntimeException("Error ao adicionar contato: "+ e.getMessage());
       }
    }

    @Override
    public ResponseEntity<Contacts> updateContact(ContactDto dto, UUID id) {
        Contacts _contact = contactRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact not found"));
        BeanUtils.copyProperties(dto, _contact);
        contactRepository.save(_contact);
        return ResponseEntity.ok(_contact);
    }

    @Override
    public ResponseEntity<String> deleteContact(UUID id) {
        contactRepository.deleteById(id);
        return ResponseEntity.status(201).body("Contato deletado");
    }

    @Override
    public ResponseEntity<Contacts> getContact(UUID id) {
        Contacts _contact = contactRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact not found"));

        return ResponseEntity.ok(_contact);
    }

    @Override
    public ResponseEntity<List<Contacts>> getAllContacts() {
        List<Contacts> _contacts = contactRepository.findAll();
        return ResponseEntity.ok(_contacts);
    }
}
