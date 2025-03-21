package com.lvsolutions.system.repository;

import com.lvsolutions.system.dto.Customers.CustomerStatusDTO;
import com.lvsolutions.system.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface CustomersRepository extends JpaRepository<Customers,UUID> {
    @Query("SELECT c FROM Customers c WHERE c.user.id = :userId")
    List<Customers> findAllByUserId(@Param("userId") UUID userId);
    void removeCustomersById(UUID id);
    @Query("SELECT new com.lvsolutions.system.dto.Customers.CustomerStatusDTO(c.status,COUNT(c) ) FROM Customers c WHERE c.user.id = :userId GROUP BY c.status")
    List<CustomerStatusDTO> countStatusByUser(@Param("userId") UUID userId);
 }
