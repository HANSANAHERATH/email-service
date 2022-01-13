package com.example.email.exception;

public class MessageException extends RuntimeException {
    public MessageException(){
        super("Messaging runtime exception");
    }
}
