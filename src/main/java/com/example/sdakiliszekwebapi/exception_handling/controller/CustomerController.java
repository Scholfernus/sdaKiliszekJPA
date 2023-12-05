package com.example.sdakiliszekwebapi.exception_handling.controller;

import com.example.sdakiliszekwebapi.exception_handling.model.Customer;
import com.example.sdakiliszekwebapi.exception_handling.service.CustomerService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Data
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/getCustomer/{id}")
    public Customer gestCustomer(@PathVariable("id")Long id){
        return customerService.getCustomer(id);
    }
}
