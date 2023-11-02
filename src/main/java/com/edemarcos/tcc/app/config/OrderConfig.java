package com.edemarcos.tcc.app.config;

import com.edemarcos.tcc.app.order.entrypoint.mapper.OrderMapperController;
import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.customer.usecases.FindByIdCustomerUseCase;
import com.edemarcos.tcc.domain.order.dataproviders.OrderDataProvider;
import com.edemarcos.tcc.domain.order.usecasesimpl.FindByIdOrderUseCaseImpl;
import com.edemarcos.tcc.domain.order.usecasesimpl.InsertOrderUseCaseImpl;
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
            FindByIdUserUseCase findByIdUserUseCase
    ) {
        return new InsertOrderUseCaseImpl(orderDataProvider, findByIdCustomerUseCase, findByIdUserUseCase );
    }
}
