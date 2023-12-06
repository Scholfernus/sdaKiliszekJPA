package com.example.sdakiliszekwebapi.controller;

import com.example.sdakiliszekwebapi.dto.CustomerDto;
import com.example.sdakiliszekwebapi.exception.CustomerAlreadyExistsException;
import com.example.sdakiliszekwebapi.handlers.ErrorResponse;
import com.example.sdakiliszekwebapi.model.Customer;
import com.example.sdakiliszekwebapi.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/getCustomer/{id}")
    public Customer gestCustomer(@PathVariable("id") Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody @Valid CustomerDto customerDto) {
        return customerService.addCustomer(customerDto);
    }

    @PutMapping("/updateCustomer")
    public String updateCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerDto);
    }

    @ExceptionHandler(value = CustomerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleCustomerAlreadyExistsException(
            CustomerAlreadyExistsException ex) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                ex.getMessage());
    }
}
