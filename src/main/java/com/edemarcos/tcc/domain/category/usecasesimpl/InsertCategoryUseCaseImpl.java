package com.edemarcos.tcc.domain.category.usecasesimpl;

import com.edemarcos.tcc.domain.category.dataproviders.CategoryDataProvider;
import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.category.exceptions.CategoryInsertionException;
import com.edemarcos.tcc.domain.category.usecases.FindByIdCategoryUseCase;
import com.edemarcos.tcc.domain.category.usecases.InsertCategoryUseCase;

public class InsertCategoryUseCaseImpl implements InsertCategoryUseCase {

    private final CategoryDataProvider categoryDataProvider;

    public InsertCategoryUseCaseImpl(CategoryDataProvider categoryDataProvider){

        this.categoryDataProvider = categoryDataProvider;
    }

    @Override
    public Category execute(Category category) {
        if (category.getName() == null || category.getDescription() == null) {
            throw new CategoryInsertionException("Existem campos vazios");
        }

        var categoryInserted = categoryDataProvider.insert(category);

        return categoryInserted;
    }
}
