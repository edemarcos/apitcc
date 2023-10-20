package com.edemarcos.tcc.app.product.dataproviders;

import com.edemarcos.tcc.app.product.dataproviders.mapper.ProductMapper;
import com.edemarcos.tcc.app.product.dataproviders.model.ProductModel;
import com.edemarcos.tcc.app.product.dataproviders.repository.ProductRepository;
import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.category.exceptions.CategoryNotFoundException;
import com.edemarcos.tcc.domain.product.dataproviders.ProductDataProvider;
import com.edemarcos.tcc.domain.product.entities.Product;
import com.edemarcos.tcc.domain.product.exceptions.ProductNotFoundException;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDataProviderImpl implements ProductDataProvider {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product insert(Product product) {
        ProductModel productModel = productMapper.toProductModel(product);

        ProductModel savedProductModel = productRepository.save(productModel);

        return productMapper.toProduct(savedProductModel);
    }
    @Override
    public Product findById(Long id) {

        ProductModel productModel = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        return productMapper.toProduct(productModel);
    }

    @Override
    public List<Product> findAll() {
        List<ProductModel> productModelList = productRepository.findAll();

        return productMapper.toProductList(productModelList);
    }

    @Override
    public void update(Product product) {
        ProductModel productModel = productMapper.toProductModel(product);

        productRepository.save(productModel);
    }


    @Override
    public void delete(Long id) {

    }
}
