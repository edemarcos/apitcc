package com.edemarcos.tcc.domain.product.usecases;

import com.edemarcos.tcc.domain.product.entities.Product;

public interface UpdateProductUseCase {
    void execute( Product product,Long id);
}
