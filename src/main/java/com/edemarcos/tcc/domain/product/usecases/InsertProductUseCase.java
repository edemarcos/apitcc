package com.edemarcos.tcc.domain.product.usecases;

import com.edemarcos.tcc.domain.product.entities.Product;

public interface InsertProductUseCase {
    Product execute(Product product);
}
