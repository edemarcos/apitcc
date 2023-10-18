package com.edemarcos.tcc.domain.category.exceptions;

public class CategoryInsertionException extends RuntimeException {
    public CategoryInsertionException(String message) {
        super("Falha ao inserir categoria: " + message);
    }
}