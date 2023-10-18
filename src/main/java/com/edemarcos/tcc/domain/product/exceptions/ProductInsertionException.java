package com.edemarcos.tcc.domain.product.exceptions;

public class ProductInsertionException extends RuntimeException {
    public ProductInsertionException(String message) {
        super("Falha ao inserir produto"+message);
    }
}
