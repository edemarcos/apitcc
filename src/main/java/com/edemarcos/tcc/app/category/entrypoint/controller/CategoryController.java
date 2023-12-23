package com.edemarcos.tcc.app.category.entrypoint.controller;


import com.edemarcos.tcc.app.category.entrypoint.controller.mapper.CategoryMapperController;
import com.edemarcos.tcc.app.category.entrypoint.controller.request.CategoryRequest;
import com.edemarcos.tcc.app.category.entrypoint.controller.response.CategoryResponse;
import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.category.usecases.FindAllCategoryUseCase;
import com.edemarcos.tcc.domain.category.usecases.FindByIdCategoryUseCase;
import com.edemarcos.tcc.domain.category.usecases.InsertCategoryUseCase;
import com.edemarcos.tcc.domain.category.usecases.UpdateCategoryUseCase;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@Tag(name = "Category", description = "Category API")
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

    @Operation(summary = "Criar nova categoria", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida: Existem campos vazios"),
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = "{\"name\": \"Perfumaria\", \"description\": \"Categoria que engloba produtos de fragrância como perfumes, " +
                                    "colônias, desodorantes, sabonetes líquidos, etc.\"}"
                    )
            )
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest categoryRequest) {
        System.out.println(categoryRequest);
        var category = categoryMapperController.toCategory(categoryRequest);
        Category createdCategory = insertCategoryUseCase.execute(category);
        CategoryResponse categoryResponse = categoryMapperController.toCategoryResponse(createdCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }

    @Operation(summary = "Atualizar categoria existente", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Categoria atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida: Existem campos vazios"),
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = "{\"name\": \"Perfumaria\", \"description\": \"Categoria atualizada com novas informações.\"}"
                    )
            )
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategory(@PathVariable final Long id, @RequestBody CategoryRequest categoryRequest) {
        var category = categoryMapperController.toCategory(categoryRequest);
        updateCategoryUseCase.execute(category, id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar categoria por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria encontrada"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable final Long id) {
        var category = findByIdCategoryUseCase.execute(id);
        var categoryResponse = categoryMapperController.toCategoryResponse(category);
        return ResponseEntity.ok().body(categoryResponse);
    }

    @Operation(summary = "Listar todas as categorias", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso"),
    })
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        var categoryList = findAllCategoryUseCase.execute();
        var categoryResponseList = categoryMapperController.toCategoryResponseList(categoryList);
        return ResponseEntity.ok().body(categoryResponseList);
    }
}
