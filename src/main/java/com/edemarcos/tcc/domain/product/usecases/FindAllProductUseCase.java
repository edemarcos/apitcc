package com.edemarcos.tcc.domain.product.usecases;

import com.edemarcos.tcc.domain.product.entities.Product;

import java.util.List;

public interface FindAllProductUseCase {
    List<Product> execute();
}
