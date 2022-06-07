package com.example.demo.exception;

public class WrongParameterException extends RuntimeException {

    public WrongParameterException(String message) {
        super(message);
    }
}
