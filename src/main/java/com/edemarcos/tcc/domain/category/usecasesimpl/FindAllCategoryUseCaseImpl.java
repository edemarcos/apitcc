package com.edemarcos.tcc.domain.category.usecasesimpl;

import com.edemarcos.tcc.domain.category.dataproviders.CategoryDataProvider;
import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.category.exceptions.CategoryNotFoundException;
import com.edemarcos.tcc.domain.category.usecases.FindAllCategoryUseCase;

import java.util.List;

public class FindAllCategoryUseCaseImpl implements FindAllCategoryUseCase {

    private final CategoryDataProvider categoryDataProvider;

    public FindAllCategoryUseCaseImpl(CategoryDataProvider categoryDataProvider){
        this.categoryDataProvider = categoryDataProvider;
    }
    @Override
    public List<Category> execute() {
        var categoryList = categoryDataProvider.findAll();
        if (categoryList == null) {
            throw new CategoryNotFoundException(null);
        }
        return categoryList;
    }
}
