package com.lvsolutions.system.repository;

import com.lvsolutions.system.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<Contacts, UUID> {
    boolean existsByEmail(String email);
}
