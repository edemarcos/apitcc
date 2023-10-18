package com.edemarcos.tcc.domain.category.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super("Categorias não encontradas: " + id);
    }
}