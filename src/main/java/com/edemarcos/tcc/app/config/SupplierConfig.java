package com.edemarcos.tcc.app.config;

import com.edemarcos.tcc.app.supplier.entrypoint.controller.SupplierController;
import com.edemarcos.tcc.domain.supplier.dataproviders.SupplierDataProvider;
import com.edemarcos.tcc.domain.supplier.usecasesimpl.FindAllSupplierUseCaseImpl;
import com.edemarcos.tcc.domain.supplier.usecasesimpl.FindByIdSupplierUseCaseImpl;
import com.edemarcos.tcc.domain.supplier.usecasesimpl.InsertSupplierUseCaseImpl;
import com.edemarcos.tcc.domain.supplier.usecasesimpl.UpdateSupplierUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupplierConfig {

    @Bean
    public InsertSupplierUseCaseImpl insertSupplierUseCase(
            SupplierDataProvider supplierDataProvider
    ){
        return new InsertSupplierUseCaseImpl(supplierDataProvider);
    }
    @Bean
    public FindAllSupplierUseCaseImpl findAllSupplierUseCase(
            SupplierDataProvider supplierDataProvider
    ){
        return new FindAllSupplierUseCaseImpl(supplierDataProvider);
    }

    @Bean
    public FindByIdSupplierUseCaseImpl findByIdSupplierUseCase(
            SupplierDataProvider supplierDataProvider
    ){
        return new FindByIdSupplierUseCaseImpl(supplierDataProvider);
    }

    @Bean
    public UpdateSupplierUseCaseImpl updateSupplierUseCase(
            SupplierDataProvider supplierDataProvider,
            FindByIdSupplierUseCaseImpl findByIdSupplierUseCase
    ){
        return new UpdateSupplierUseCaseImpl(findByIdSupplierUseCase, supplierDataProvider);
    }

}
