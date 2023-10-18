package com.edemarcos.tcc.domain.supplier.exceptions;

public class SupplierNotFoundException extends RuntimeException {
    public SupplierNotFoundException(Long id) {
        super("Fornecedor não encontrados: " + id);
    }
}