package com.edemarcos.tcc.domain.order.exceptions;

public class OrderInsertionException extends RuntimeException {
    public OrderInsertionException(String message) {
        super(message);
    }
}
