package com.edemarcos.tcc.domain.category.exceptions;

public class CategoryUpdateException extends RuntimeException {
    public CategoryUpdateException(String message) {
        super("Falha ao atualizar categoria: " + message);
    }
}