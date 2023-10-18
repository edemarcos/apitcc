package com.edemarcos.tcc.domain.supplier.exceptions;

public class SupplierDeletionException extends RuntimeException {
    public SupplierDeletionException(String message) {
        super("Falha ao excluir fornecedor: " + message);
    }
}
