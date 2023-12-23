package com.edemarcos.tcc.app.product.entrypoint.controller;

import com.edemarcos.tcc.app.product.entrypoint.controller.mapper.ProductMapperController;
import com.edemarcos.tcc.app.product.entrypoint.controller.request.ProductRequest;
import com.edemarcos.tcc.app.product.entrypoint.controller.response.ProductResponse;
import com.edemarcos.tcc.domain.product.entities.Product;
import com.edemarcos.tcc.domain.product.usecases.FindAllProductUseCase;
import com.edemarcos.tcc.domain.product.usecases.FindByIdProductUseCase;
import com.edemarcos.tcc.domain.product.usecases.InsertProductUseCase;
import com.edemarcos.tcc.domain.product.usecases.UpdateProductUseCase;
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
@RequestMapping("/api/v1/product")
@Tag(name = "Product", description = "Product API")
public class ProductController {
    @Autowired
    private InsertProductUseCase insertProductUseCase;
    @Autowired
    private FindByIdProductUseCase findByIdProductUseCase;
    @Autowired
    private FindAllProductUseCase findAllProductUseCase;
    @Autowired
    private UpdateProductUseCase updateProductUseCase;
    @Autowired
    private ProductMapperController productMapperController;

    @Operation(summary = "Inserir novo produto", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto criado"),
            @ApiResponse(responseCode = "500", description = "Falha ao inserir produto: Existem campos vazios"),
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = "{\"name\": \"Produto Teste\", \"categoryId\": 1, \"description\": \"Descrição do produto teste\", " +
                                    "\"unitPrice\": 50.00, \"supplierId\": 1, \"initialQuantity\": 100, \"registrationDate\": \"2023-11-13T12:00:00\", " +
                                    "\"weight\": 1.5, \"dimensions\": \"10x5x2\", \"status\": \"ACTIVE\"}"
                    )
            )
    )
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ProductRequest productRequest) {
        var product = productMapperController.toProduct(productRequest);
        Product createdProduct = insertProductUseCase.execute(product);
        ProductResponse productResponse = productMapperController.toProductResponse(createdProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @Operation(summary = "Buscar produto por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable final Long id) {
        Product product = findByIdProductUseCase.execute(id);
        ProductResponse productResponse = productMapperController.toProductResponse(product);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @Operation(summary = "Listar todos os produtos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso"),
    })
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        var products = findAllProductUseCase.execute();
        List<ProductResponse> productResponseList = productMapperController.toProductResponseList(products);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseList);
    }

    @Operation(summary = "Atualizar produto existente", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Falha ao atualizar produto: Existem campos vazios"),
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = "{\"name\": \"Produto Atualizado\", \"categoryId\": 2, \"description\": \"Nova descrição do produto\", " +
                                    "\"unitPrice\": 60.00, \"supplierId\": 2, \"initialQuantity\": 150, \"registrationDate\": \"2023-11-13T12:00:00\", " +
                                    "\"weight\": 2.0, \"dimensions\": \"12x6x3\", \"status\": \"ACTIVE\"}"
                    )
            )
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProductRequest productRequest, @PathVariable final Long id) {
        var product = productMapperController.toProduct(productRequest);
        product.setId(id);
        updateProductUseCase.execute(product, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}