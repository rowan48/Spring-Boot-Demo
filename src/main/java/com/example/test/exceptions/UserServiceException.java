package com.example.test.exceptions;

public class UserServiceException extends  RuntimeException{
    private static final long serialVersionUID=1348771109171435607l;
    public UserServiceException(String message) {
        super(message);
    }
}
