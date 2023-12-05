package com.example.sdakiliszekwebapi.exception_handling.service;

import com.example.sdakiliszekwebapi.exception_handling.model.Customer;
import com.example.sdakiliszekwebapi.exception_handling.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    /* Method to get customer by Id. Throws
    NoSuchElementException for invalid Id.*/
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(()->
        new NoSuchElementException("No Customer present with id = " + id));
    }
}
