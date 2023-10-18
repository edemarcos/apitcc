package com.edemarcos.tcc.domain.customer.exceptions;

public class CustomerDeletionException extends RuntimeException {
    public CustomerDeletionException(String message) {
        super("Falha ao excluir cliente: " + message);
    }
}
