package com.example.sdakiliszekwebapi.exception;

public class NoSuchCustomerExistsException extends RuntimeException{

    public NoSuchCustomerExistsException(String message, String message1) {
        super(message);
    }

    public NoSuchCustomerExistsException() {
    }

    public NoSuchCustomerExistsException(String s) {
    }
}
