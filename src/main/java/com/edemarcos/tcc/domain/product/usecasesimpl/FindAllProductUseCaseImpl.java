package com.edemarcos.tcc.domain.product.usecasesimpl;

import com.edemarcos.tcc.domain.product.dataproviders.ProductDataProvider;
import com.edemarcos.tcc.domain.product.entities.Product;
import com.edemarcos.tcc.domain.product.exceptions.ProductNotFoundException;
import com.edemarcos.tcc.domain.product.usecases.FindAllProductUseCase;

import java.util.List;


public class FindAllProductUseCaseImpl implements FindAllProductUseCase {
    private ProductDataProvider productDataProvider;

    public FindAllProductUseCaseImpl(ProductDataProvider productDataProvider) {
        this.productDataProvider = productDataProvider;
    }
    @Override
    public List<Product> execute() {
        try {
            var productList = productDataProvider.findAll();
            return productList;
        } catch (ProductNotFoundException e) {
            throw new ProductNotFoundException(null);
        }

    }
}
