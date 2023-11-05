package com.edemarcos.tcc.domain.order.exceptions;

public class NoItemException extends RuntimeException {
    public NoItemException(String message) {
        super(message);
    }
}
