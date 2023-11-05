package com.edemarcos.tcc.app.product.dataproviders.mapper;

import com.edemarcos.tcc.app.category.dataproviders.mapper.CategoryMapper;
import com.edemarcos.tcc.app.product.dataproviders.model.ProductModel;
import com.edemarcos.tcc.app.supplier.dataproviders.mapper.SupplierMapper;
import com.edemarcos.tcc.domain.product.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    public Product toProduct(ProductModel productModel) {
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
        var productList = new ArrayList<Product>();
        for (ProductModel productModel : productModelList) {
            productList.add(toProduct(productModel));
        }
        return productList;
    }
}
