package com.example.sdakiliszekwebapi.exception;

public class CustomerAlreadyExistsException extends RuntimeException {

    public CustomerAlreadyExistsException(String message, String message1) {
        super(message);
    }

    public CustomerAlreadyExistsException(String message) {
    }

    public CustomerAlreadyExistsException() {
    }
}
