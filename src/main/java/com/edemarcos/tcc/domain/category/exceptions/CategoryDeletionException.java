package com.edemarcos.tcc.domain.category.exceptions;

public class CategoryDeletionException extends RuntimeException {
    public CategoryDeletionException(String message) {
        super("Falha ao excluir categoria: " + message);
    }
}
