package com.edemarcos.tcc.domain.product.exceptions;

public class ProductUpdateException extends RuntimeException {
    public ProductUpdateException(Long id) {
        super("Produtos não autualizado: " + id);
    }
}