package com.edemarcos.tcc.app.config;

import com.edemarcos.tcc.domain.authentication.dataproviders.AuthenticationDataProvider;
import com.edemarcos.tcc.domain.authentication.usecasesimpl.GenerateTokenUseCaseImpl;
import com.edemarcos.tcc.domain.authentication.usecasesimpl.ValidateTokenUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationConfig {
    @Bean
    public GenerateTokenUseCaseImpl generateTokenUseCase (
            AuthenticationDataProvider authenticationDataProvider
    ) {
        return new GenerateTokenUseCaseImpl(authenticationDataProvider);
    }
    @Bean
    public ValidateTokenUseCaseImpl validateTokenUseCase (
            AuthenticationDataProvider authenticationDataProvider
    ) {
        return new ValidateTokenUseCaseImpl(authenticationDataProvider);
    }
}
