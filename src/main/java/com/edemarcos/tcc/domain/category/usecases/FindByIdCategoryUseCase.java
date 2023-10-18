package com.edemarcos.tcc.domain.category.usecases;

import com.edemarcos.tcc.domain.category.entities.Category;

public interface FindByIdCategoryUseCase {
    Category execute(Long id);
}
