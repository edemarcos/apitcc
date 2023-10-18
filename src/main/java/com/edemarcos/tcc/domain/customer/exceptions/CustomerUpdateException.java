package com.edemarcos.tcc.domain.customer.exceptions;

public class CustomerUpdateException extends RuntimeException {
    public CustomerUpdateException(String message) {
        super("Falha ao atualizar cliente: " + message);
    }
}