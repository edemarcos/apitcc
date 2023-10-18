package com.edemarcos.tcc.domain.category.usecasesimpl;

import com.edemarcos.tcc.domain.category.dataproviders.CategoryDataProvider;
import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.category.exceptions.CategoryNotFoundException;
import com.edemarcos.tcc.domain.category.usecases.FindByIdCategoryUseCase;

public class FindByIdCategoryUseCaseImpl implements FindByIdCategoryUseCase {
    private final CategoryDataProvider categoryDataProvider;

    public FindByIdCategoryUseCaseImpl(CategoryDataProvider categoryDataProvider){
        this.categoryDataProvider = categoryDataProvider;
    }
    @Override
    public Category execute(Long id) {
        var category = categoryDataProvider.findById(id);

        if (category == null) {
            throw new CategoryNotFoundException(id);
        }

        return category;
    }
}
