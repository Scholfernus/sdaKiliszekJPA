package com.example.sdakiliszekwebapi.exception_handling.repository;

import com.example.sdakiliszekwebapi.exception_handling.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
boolean existsByName(String name);
}
