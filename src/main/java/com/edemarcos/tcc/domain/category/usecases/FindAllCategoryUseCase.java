package com.edemarcos.tcc.domain.category.usecases;

import com.edemarcos.tcc.domain.category.entities.Category;

import java.util.List;

public interface FindAllCategoryUseCase {
    List<Category> execute();
}
