package com.edemarcos.tcc.domain.category.usecases;

import com.edemarcos.tcc.domain.category.entities.Category;

public interface InsertCategoryUseCase {
    Category execute(Category category);

}
