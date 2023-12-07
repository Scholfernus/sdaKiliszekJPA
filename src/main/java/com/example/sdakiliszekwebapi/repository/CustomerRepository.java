package com.example.sdakiliszekwebapi.repository;

import com.example.sdakiliszekwebapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByName(String name);
}
