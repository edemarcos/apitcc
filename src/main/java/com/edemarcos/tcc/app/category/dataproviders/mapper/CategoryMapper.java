package com.edemarcos.tcc.app.category.dataproviders.mapper;

import com.edemarcos.tcc.app.category.dataproviders.model.CategoryModel;
import com.edemarcos.tcc.domain.category.entities.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public CategoryModel toCategoryModel(Category category) {
        return new CategoryModel(category.getId(), category.getName(), category.getDescription());
    }

    public Category toCategory(CategoryModel categoryModel) {
        return new Category(categoryModel.getId(),categoryModel.getName(), categoryModel.getDescription());
    }

    public List<Category> toCategoryList(List<CategoryModel> categoryModelList) {
        return categoryModelList.stream().map(this::toCategory).collect(Collectors.toList());
    }
}
