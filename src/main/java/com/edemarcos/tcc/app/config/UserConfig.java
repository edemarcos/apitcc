package com.edemarcos.tcc.app.config;

import com.edemarcos.tcc.domain.user.dataproviders.UserDataProvider;
import com.edemarcos.tcc.domain.user.usecasesimpl.FindByIdUserUseCaseImpl;
import com.edemarcos.tcc.domain.user.usecasesimpl.InsertUserUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public InsertUserUseCaseImpl insertUserUseCase(UserDataProvider userDataProvider) {
        return new InsertUserUseCaseImpl(userDataProvider);
    }

    @Bean
    public FindByIdUserUseCaseImpl findByIdUserUseCase(UserDataProvider userDataProvider) {
        return new FindByIdUserUseCaseImpl(userDataProvider);
    }
}
