package com.edemarcos.tcc.app.product.entrypoint.controller;

import com.edemarcos.tcc.app.product.entrypoint.controller.mapper.ProductMapperController;
import com.edemarcos.tcc.app.product.entrypoint.controller.request.ProductRequest;
import com.edemarcos.tcc.app.product.entrypoint.controller.response.ProductResponse;
import com.edemarcos.tcc.domain.product.entities.Product;
import com.edemarcos.tcc.domain.product.usecases.FindAllProductUseCase;
import com.edemarcos.tcc.domain.product.usecases.FindByIdProductUseCase;
import com.edemarcos.tcc.domain.product.usecases.InsertProductUseCase;
import com.edemarcos.tcc.domain.product.usecases.UpdateProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
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
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ProductRequest productRequest ) {
        var product = productMapperController.toProduct(productRequest) ;
        Product createdProduct = insertProductUseCase.execute(product);
        ProductResponse productResponse = productMapperController.toProductResponse(createdProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable final Long id) {
        Product product = findByIdProductUseCase.execute(id);
        ProductResponse productResponse = productMapperController.toProductResponse(product);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        var products = findAllProductUseCase.execute();
        List<ProductResponse> productResponseList = productMapperController.toProductResponseList(products);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProductRequest productRequest, @PathVariable final Long id) {
        var product = productMapperController.toProduct(productRequest);
        product.setId(id);
        updateProductUseCase.execute(product, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
