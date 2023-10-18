package com.edemarcos.tcc.domain.supplier.exceptions;

public class SupplierUpdateException extends RuntimeException {
    public SupplierUpdateException(String message) {
        super("Falha ao atualizar fornecedor: " + message);
    }
}