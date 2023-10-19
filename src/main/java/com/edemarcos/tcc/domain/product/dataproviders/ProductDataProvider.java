package com.edemarcos.tcc.domain.product.dataproviders;

import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.product.entities.Product;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;

public interface ProductDataProvider {
    Product insert(Product product);
    Product findById(Long id);
    void update(Product product);
    void delete(Long id);
}