package com.edemarcos.tcc.domain.product.usecases;

import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.product.entities.Product;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;

public interface InsertProductUseCase {
    Product execute(Product product);
}
