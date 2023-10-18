package com.edemarcos.tcc.domain.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("Clientes não encontrados: " + id);
    }
}