package com.edemarcos.tcc.app.config;

import com.edemarcos.tcc.domain.category.usecases.FindByIdCategoryUseCase;
import com.edemarcos.tcc.domain.product.dataproviders.ProductDataProvider;
import com.edemarcos.tcc.domain.product.usecases.FindByIdProductUseCase;
import com.edemarcos.tcc.domain.product.usecasesimpl.FindAllProductUseCaseImpl;
import com.edemarcos.tcc.domain.product.usecasesimpl.FindByIdProductUseCaseImpl;
import com.edemarcos.tcc.domain.product.usecasesimpl.InsertProductUseCaseImpl;
import com.edemarcos.tcc.domain.product.usecasesimpl.UpdateProductUseCaseImpl;
import com.edemarcos.tcc.domain.supplier.usecases.FindByIdSupplierUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    public InsertProductUseCaseImpl insertProductUseCase(
            ProductDataProvider productDataProvider,
            FindByIdCategoryUseCase findByIdCategoryUse,
            FindByIdSupplierUseCase findSupplierByIdUseCase
    ){
        return new InsertProductUseCaseImpl(productDataProvider, findByIdCategoryUse, findSupplierByIdUseCase);
    }
    @Bean
    public FindByIdProductUseCaseImpl findByIdProductUseCase(ProductDataProvider productDataProvider){
        return new FindByIdProductUseCaseImpl(productDataProvider);
    }

    @Bean
    public FindAllProductUseCaseImpl findAllProductUseCase(ProductDataProvider productDataProvider){
        return new FindAllProductUseCaseImpl(productDataProvider);
    }
    @Bean
    public UpdateProductUseCaseImpl updateProductUseCase(
            FindByIdProductUseCase findByIdProductUseCase,
            ProductDataProvider productDataProvider
    ){
        return new UpdateProductUseCaseImpl(findByIdProductUseCase, productDataProvider);
    }

}
