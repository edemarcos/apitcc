package com.edemarcos.tcc.domain.category.usecasesimpl;

import com.edemarcos.tcc.domain.category.dataproviders.CategoryDataProvider;
import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.category.exceptions.CategoryNotFoundException;
import com.edemarcos.tcc.domain.category.exceptions.CategoryUpdateException;
import com.edemarcos.tcc.domain.category.usecases.FindByIdCategoryUseCase;
import com.edemarcos.tcc.domain.category.usecases.UpdateCategoryUseCase;

public class UpdateCategoryUseCaseImpl implements UpdateCategoryUseCase {

    private final CategoryDataProvider categoryDataProvider;
    private final FindByIdCategoryUseCase findByIdCategoryUseCase;

    public UpdateCategoryUseCaseImpl(CategoryDataProvider categoryDataProvider, FindByIdCategoryUseCase findByIdCategoryUseCase){

        this.categoryDataProvider = categoryDataProvider;
        this.findByIdCategoryUseCase = findByIdCategoryUseCase;
    }

    @Override
    public void execute(Category category , Long id) {
        if (category.getName() == null || category.getDescription() == null) {
            throw new CategoryUpdateException("Existem campos vazios");
        }
        Category categoryUpdate = findByIdCategoryUseCase.execute(id);
        categoryUpdate.setName(category.getName());
        categoryUpdate.setDescription(category.getDescription());

        categoryDataProvider.update(categoryUpdate);
    }
}
