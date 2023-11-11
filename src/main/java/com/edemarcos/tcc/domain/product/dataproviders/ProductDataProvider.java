package com.edemarcos.tcc.domain.product.dataproviders;

import com.edemarcos.tcc.domain.product.entities.Product;

import java.util.List;

public interface ProductDataProvider {
    Product insert(Product product);
    Product findById(Long id);
    List<Product> findAll();
    void update(Product product);
}
