package com.edemarcos.tcc.domain.product.usecasesimpl;

import com.edemarcos.tcc.domain.product.dataproviders.ProductDataProvider;
import com.edemarcos.tcc.domain.product.entities.Product;
import com.edemarcos.tcc.domain.product.exceptions.ProductNotFoundException;
import com.edemarcos.tcc.domain.product.usecases.FindByIdProductUseCase;

public class FindByIdProductUseCaseImpl implements FindByIdProductUseCase {
    private ProductDataProvider productDataProvider;

    public FindByIdProductUseCaseImpl(ProductDataProvider productDataProvider) {
        this.productDataProvider = productDataProvider;
    }
    @Override
    public Product execute(Long id) {
        var product = productDataProvider.findById(id);
        if (product == null) {
            throw new ProductNotFoundException(id);
        }
        return product;
    }
}
