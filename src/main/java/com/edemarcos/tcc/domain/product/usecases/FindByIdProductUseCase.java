package com.edemarcos.tcc.domain.product.usecases;

import com.edemarcos.tcc.domain.product.entities.Product;

public interface FindByIdProductUseCase {
    Product execute(Long id);
}
