package com.edemarcos.tcc.domain.category.dataproviders;

import com.edemarcos.tcc.domain.category.entities.Category;

import java.util.List;

public interface CategoryDataProvider {
    Category insert(Category category);
    void update(Category category);
    Category findById(Long id);
    void delete(Long id);
    List<Category> findAll();
}
