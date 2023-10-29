package com.edemarcos.tcc.domain.user.exceptions;

public class UserAlredyExistsException extends RuntimeException{
    public UserAlredyExistsException(String message) {
        super(message);
    }
}
