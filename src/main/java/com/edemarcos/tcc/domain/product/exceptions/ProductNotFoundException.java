package com.edemarcos.tcc.domain.product.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Produtos não encontrados: " + id);
    }
}