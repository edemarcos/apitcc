package com.edemarcos.tcc.app.category.dataproviders;

import com.edemarcos.tcc.app.category.dataproviders.mapper.CategoryMapper;
import com.edemarcos.tcc.app.category.dataproviders.model.CategoryModel;
import com.edemarcos.tcc.app.category.dataproviders.repository.CategoryRepository;
import com.edemarcos.tcc.domain.category.dataproviders.CategoryDataProvider;
import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.category.exceptions.CategoryNotFoundException;
import com.edemarcos.tcc.domain.category.exceptions.CategoryUpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDataProviderImpl implements CategoryDataProvider {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category insert(Category category) {
        var categoryEntity = categoryMapper.toCategoryModel(category);
        var categorySaved = categoryRepository.save(categoryEntity);
        return categoryMapper.toCategory(categorySaved);
    }

    @Override
    public void update(Category category) {
        var categoryEntity = categoryMapper.toCategoryModel(category);
        try{
        categoryRepository.save(categoryEntity);

        }catch (CategoryUpdateException e){
            throw new CategoryUpdateException(e.getMessage());
        }
    }

    @Override
    public Category findById(Long id) {

            CategoryModel categoryModel = categoryRepository.findById(id).orElseThrow(
                    () -> new CategoryNotFoundException(id));;
            return categoryMapper.toCategory(categoryModel);


    }

    @Override
    public List<Category> findAll() {
        List<CategoryModel> categoryModelList = categoryRepository.findAll();
        return categoryMapper.toCategoryList(categoryModelList);
    }

    @Override
    public void delete(Long id) {
    }
}
