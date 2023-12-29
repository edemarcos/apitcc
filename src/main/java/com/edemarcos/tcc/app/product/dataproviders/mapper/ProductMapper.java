package com.edemarcos.tcc.app.product.dataproviders.mapper;

import com.edemarcos.tcc.app.category.dataproviders.mapper.CategoryMapper;
import com.edemarcos.tcc.app.product.dataproviders.model.ProductModel;
import com.edemarcos.tcc.app.supplier.dataproviders.mapper.SupplierMapper;
import com.edemarcos.tcc.domain.product.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public Product toProduct(ProductModel productModel) {
        if (productModel != null){
            var category = new CategoryMapper().toCategory(productModel.getCategory());
            var supplier = new SupplierMapper().toSupplier(productModel.getSupplier());
            return new Product(
                    productModel.getId(),
                    productModel.getName(),
                    category,
                    productModel.getDescription(),
                    productModel.getUnitPrice(),
                    supplier,
                    productModel.getQuantity(),
                    productModel.getRegistrationDate(),
                    productModel.getWeight(),
                    productModel.getDimensions(),
                    productModel.getStatus()
            );
        }
        return new Product();
    }
    public ProductModel toProductModel(Product product) {
        var categoryModel = new CategoryMapper().toCategoryModel(product.getCategory());
        var supplierModel = new SupplierMapper().toSupplierModel(product.getSupplier());
        return new ProductModel(
                product.getId(),
                product.getName(),
                categoryModel,
                product.getDescription(),
                product.getUnitPrice(),
                supplierModel,
                product.getQuantity(),
                product.getRegistrationDate(),
                product.getWeight(),
                product.getDimensions(),
                product.getStatus()

        );
    }

    public List<Product> toProductList(List<ProductModel> productModelList) {
        return productModelList.stream().map(this::toProduct).collect(Collectors.toList());
    }
}
