package com.edemarcos.tcc.domain.supplier.exceptions;

public class SupplierInsertionException extends RuntimeException {
    public SupplierInsertionException(String message) {
        super("Falha ao inserir fornecedor: " + message);
    }
}