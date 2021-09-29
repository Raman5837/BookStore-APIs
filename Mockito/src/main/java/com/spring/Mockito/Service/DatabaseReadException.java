package com.spring.Mockito.Service;

public class DatabaseReadException extends RuntimeException {
    public DatabaseReadException(String message) {

        super(message);
        System.out.println(message);
    }
}
