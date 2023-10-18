package com.edemarcos.tcc.domain.customer.exceptions;

public class CustomerInsertionException extends RuntimeException {
    public CustomerInsertionException(String message) {
        super("Falha ao inserir cliente: " + message);
    }
}