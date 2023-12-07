package com.example.sdakiliszekwebapi.service;

import com.example.sdakiliszekwebapi.dto.CustomerDto;
import com.example.sdakiliszekwebapi.exception.CustomerAlreadyExistsException;
import com.example.sdakiliszekwebapi.exception.NoSuchCustomerExistsException;
import com.example.sdakiliszekwebapi.model.Customer;
import com.example.sdakiliszekwebapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    /* Method to get customer by Id. throws NoSuchElementException for invalid Id.*/
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("No Customer present under id = " + id));
    }
    /*Method to add new customer details to database.Throws CustomerAlreadyExistsException when customer detail
     already exist*/
    public String addCustomer(CustomerDto customerDto) {
        boolean customerExists = customerRepository.existsByName(customerDto.getName());
        if (!customerExists) {
            Customer customerNew = new Customer();
            customerNew.setName(customerDto.getName());
            customerNew.setAddress(customerDto.getAddress());
            customerRepository.save(customerNew);
            return "Customer added successfully";
        } else {
            throw new CustomerAlreadyExistsException("Customer already exists!");
        }
    }


    public String updateCustomer(CustomerDto customerDto) {
        Customer existingCustomer = customerRepository.findById(customerDto.getId()).orElseThrow(null);
        if (existingCustomer==null) {
            throw new NoSuchCustomerExistsException("No Such Customer exists!");
        } else {
            existingCustomer.setName(customerDto.getName());
            existingCustomer.setAddress(customerDto.getAddress());
            customerRepository.save(existingCustomer);
            return "Record with Customer updated successfully";
        }
    }
}
