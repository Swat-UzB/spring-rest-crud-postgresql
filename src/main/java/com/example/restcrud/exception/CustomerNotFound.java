package com.example.restcrud.exception;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound(String s) {
        super(s);
    }
}
