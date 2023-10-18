package com.edemarcos.tcc.app.category.entrypoint.controller.mapper;

import com.edemarcos.tcc.app.category.entrypoint.controller.request.CategoryRequest;
import com.edemarcos.tcc.app.category.entrypoint.controller.response.CategoryResponse;
import com.edemarcos.tcc.domain.category.entities.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapperController {
    public Category toCategory(CategoryRequest categoryRequest) {
        return new Category(categoryRequest.getName(), categoryRequest.getDescription());
    }

    public CategoryResponse toCategoryResponse(Category category) {
        return new CategoryResponse(category.getId(),category.getName(), category.getDescription());
    }

    public List<CategoryResponse> toCategoryResponseList(List<Category> categoryList) {
        return categoryList.stream().map(this::toCategoryResponse).collect(Collectors.toList());
    }

}
