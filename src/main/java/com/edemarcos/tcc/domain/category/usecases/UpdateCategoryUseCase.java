package com.edemarcos.tcc.domain.category.usecases;

import com.edemarcos.tcc.domain.category.entities.Category;

public interface UpdateCategoryUseCase {
    void execute(Category category, Long id);

}
