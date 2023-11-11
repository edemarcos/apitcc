package com.edemarcos.tcc.app.config;

import com.edemarcos.tcc.app.order.entrypoint.mapper.OrderMapperController;
import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.customer.usecases.FindByIdCustomerUseCase;
import com.edemarcos.tcc.domain.order.dataproviders.OrderDataProvider;
import com.edemarcos.tcc.domain.order.usecases.FindAllOrderUseCase;
import com.edemarcos.tcc.domain.order.usecases.GetProductOrderUseCase;
import com.edemarcos.tcc.domain.order.usecasesimpl.*;
import com.edemarcos.tcc.domain.product.usecases.FindByIdProductUseCase;
import com.edemarcos.tcc.domain.product.usecases.UpdateProductUseCase;
import com.edemarcos.tcc.domain.user.dataproviders.UserDataProvider;
import com.edemarcos.tcc.domain.user.usecases.FindByIdUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    public FindByIdOrderUseCaseImpl findByIdOrderUseCaseImpl(
            OrderDataProvider orderDataProvider
    ) {
        return new FindByIdOrderUseCaseImpl(orderDataProvider);
    }

    @Bean
    public InsertOrderUseCaseImpl insertOrderUseCaseImpl(
            OrderDataProvider orderDataProvider,
            FindByIdCustomerUseCase findByIdCustomerUseCase,
            FindByIdUserUseCase findByIdUserUseCase,
            GetProductOrderUseCase getProductOrderUseCase
    ) {
        return new InsertOrderUseCaseImpl(orderDataProvider, findByIdCustomerUseCase, findByIdUserUseCase, getProductOrderUseCase);
    }

    @Bean
    public GetProductOrderUseCaseImpl getProductOrderUseCaseImpl(
            FindByIdProductUseCase findByIdProductUseCase,
            UpdateProductUseCase updateProductUseCase
    ) {
        return new GetProductOrderUseCaseImpl(findByIdProductUseCase, updateProductUseCase);
    }

    @Bean
    public FindAllOrderUseCaseImpl findAllOrderUseCaseImpl(
            OrderDataProvider orderDataProvider
    ) {
        return new FindAllOrderUseCaseImpl(orderDataProvider);
    }

    @Bean
    public UpdateOrderUseCaseImpl updateOrderUseCaseImpl(
            OrderDataProvider orderDataProvider,
            FindByIdCustomerUseCase findByIdCustomerUseCase,
            FindByIdUserUseCase findByIdUserUseCase,
            GetProductOrderUseCase getProductOrderUseCase
    ) {
        return new UpdateOrderUseCaseImpl(orderDataProvider, findByIdCustomerUseCase, findByIdUserUseCase, getProductOrderUseCase);
    }
}
