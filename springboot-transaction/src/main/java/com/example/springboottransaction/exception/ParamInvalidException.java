package com.example.springboottransaction.exception;

public class ParamInvalidException extends RuntimeException{

    public ParamInvalidException(String message) {
        super(message);
    }
}
