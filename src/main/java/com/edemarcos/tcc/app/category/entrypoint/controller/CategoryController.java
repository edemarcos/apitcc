package com.edemarcos.tcc.app.category.entrypoint.controller;


import com.edemarcos.tcc.app.category.entrypoint.controller.mapper.CategoryMapperController;
import com.edemarcos.tcc.app.category.entrypoint.controller.request.CategoryRequest;
import com.edemarcos.tcc.app.category.entrypoint.controller.response.CategoryResponse;
import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.category.usecases.FindAllCategoryUseCase;
import com.edemarcos.tcc.domain.category.usecases.FindByIdCategoryUseCase;
import com.edemarcos.tcc.domain.category.usecases.InsertCategoryUseCase;
import com.edemarcos.tcc.domain.category.usecases.UpdateCategoryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private InsertCategoryUseCase insertCategoryUseCase;
    @Autowired
    private UpdateCategoryUseCase updateCategoryUseCase;
    @Autowired
    private FindByIdCategoryUseCase findByIdCategoryUseCase;

    @Autowired
    private FindAllCategoryUseCase findAllCategoryUseCase;

    @Autowired
    private CategoryMapperController categoryMapperController;
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody CategoryRequest categoryRequest ) {
        var category = categoryMapperController.toCategory(categoryRequest) ;
        Category createdCategory = insertCategoryUseCase.execute(category);
        CategoryResponse categoryResponse = categoryMapperController.toCategoryResponse(createdCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse>  update(@PathVariable final Long id, @RequestBody CategoryRequest categoryRequest){
        var category = categoryMapperController.toCategory(categoryRequest);
        updateCategoryUseCase.execute(category, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable final Long id){
        var category = findByIdCategoryUseCase.execute(id);
        var categoryResponse = categoryMapperController.toCategoryResponse(category);
        return ResponseEntity.ok().body(categoryResponse);
    }
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){
        var categoryList = findAllCategoryUseCase.execute();
        var categoryResponseList = categoryMapperController.toCategoryResponseList(categoryList) ;
        return ResponseEntity.ok().body(categoryResponseList);
    }
}
