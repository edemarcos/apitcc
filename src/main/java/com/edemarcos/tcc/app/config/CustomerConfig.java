package com.edemarcos.tcc.app.config;

import com.edemarcos.tcc.app.customer.entrypoint.controller.mapper.CustomerMapperController;
import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.customer.usecases.FindByIdCustomerUseCase;
import com.edemarcos.tcc.domain.customer.usecasesimpl.FindAllCustomerUseCaseImpl;
import com.edemarcos.tcc.domain.customer.usecasesimpl.FindByIdCustomerUseCaseImpl;
import com.edemarcos.tcc.domain.customer.usecasesimpl.InsertCustomerUseCaseImpl;
import com.edemarcos.tcc.domain.customer.usecasesimpl.UpdateCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(
            CustomerDataProvider customerDataProvider
    ){
        return new InsertCustomerUseCaseImpl(customerDataProvider);
    }
    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(
            CustomerDataProvider customerDataProvider,
            FindByIdCustomerUseCase findByIdCustomerUseCase
    ){
        return new UpdateCustomerUseCaseImpl(findByIdCustomerUseCase, customerDataProvider);
    }
    @Bean
    public FindByIdCustomerUseCaseImpl findByIdCustomerUseCase(
            CustomerDataProvider customerDataProvider
    ){
        return new FindByIdCustomerUseCaseImpl(customerDataProvider);
    }
    @Bean
    public FindAllCustomerUseCaseImpl findAllCustomerUseCase(
            CustomerDataProvider customerDataProvider
    ){
        return new FindAllCustomerUseCaseImpl(customerDataProvider);
    }

}
