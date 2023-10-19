package com.edemarcos.tcc.app.product.entrypoint.controller.mapper;

import com.edemarcos.tcc.app.category.entrypoint.controller.mapper.CategoryMapperController;
import com.edemarcos.tcc.app.product.entrypoint.controller.request.ProductRequest;
import com.edemarcos.tcc.app.product.entrypoint.controller.response.ProductResponse;
import com.edemarcos.tcc.domain.category.dataproviders.CategoryDataProvider;
import com.edemarcos.tcc.domain.product.entities.Product;
import com.edemarcos.tcc.domain.supplier.dataproviders.SupplierDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperController {
    @Autowired
    CategoryDataProvider categoryDataProvider;
    @Autowired
    SupplierDataProvider supplierDataProvider;

    public Product toProduct(ProductRequest productRequest) {
        var categoryModel = categoryDataProvider.findById(productRequest.getCategoryId());
        var supplierModel = supplierDataProvider.findById(productRequest.getSupplierId());

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setCategory(categoryModel);
        product.setDescription(productRequest.getDescription());
        product.setUnitPrice(productRequest.getUnitPrice());
        product.setSupplier(supplierModel);
        product.setInitialQuantity(productRequest.getInitialQuantity());
        product.setRegistrationDate(productRequest.getRegistrationDate());
        product.setWeight(productRequest.getWeight());
        product.setDimensions(productRequest.getDimensions());
        product.setStatus(productRequest.getStatus());
        return product;
    }
    public ProductResponse toProductResponse (Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setCategory(product.getCategory());
        productResponse.setDescription(product.getDescription());
        productResponse.setUnitPrice(product.getUnitPrice());
        productResponse.setSupplier(product.getSupplier());
        productResponse.setInitialQuantity(product.getInitialQuantity());
        productResponse.setRegistrationDate(product.getRegistrationDate());
        productResponse.setWeight(product.getWeight());
        productResponse.setDimensions(product.getDimensions());
        productResponse.setStatus(product.getStatus().toString());
        return productResponse;
    }
}
