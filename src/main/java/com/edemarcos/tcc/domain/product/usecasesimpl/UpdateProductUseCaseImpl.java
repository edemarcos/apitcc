package com.edemarcos.tcc.domain.product.usecasesimpl;

import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.customer.exceptions.CustomerUpdateException;
import com.edemarcos.tcc.domain.product.dataproviders.ProductDataProvider;
import com.edemarcos.tcc.domain.product.entities.Product;
import com.edemarcos.tcc.domain.product.exceptions.ProductUpdateException;
import com.edemarcos.tcc.domain.product.usecases.FindByIdProductUseCase;
import com.edemarcos.tcc.domain.product.usecases.UpdateProductUseCase;

import java.lang.reflect.Field;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {
    FindByIdProductUseCase findByIdProductUseCase;

    ProductDataProvider productDataProvider;

    public UpdateProductUseCaseImpl(FindByIdProductUseCase findByIdProductUseCase, ProductDataProvider productDataProvider){
        this.findByIdProductUseCase = findByIdProductUseCase;
        this.productDataProvider = productDataProvider;
    }
    @Override
    public void execute(Product product, Long id) {
        Product productUpdate = findByIdProductUseCase.execute(id);
        productUpdate.setId(id);

        Field[] fields = Product.class.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                field.set(productUpdate, field.get(product));
            } catch (ProductUpdateException | IllegalAccessException e) {
                throw new ProductUpdateException(id);
            }
        }

        productDataProvider.update(productUpdate);
    }
}
