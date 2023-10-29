package com.edemarcos.tcc.domain.authentication.usecasesimpl;


import com.edemarcos.tcc.domain.authentication.dataproviders.AuthenticationDataProvider;
import com.edemarcos.tcc.domain.authentication.usecases.ValidateTokenUseCase;

public class ValidateTokenUseCaseImpl implements ValidateTokenUseCase {
    private final AuthenticationDataProvider authenticationDataProvider;

    public ValidateTokenUseCaseImpl(AuthenticationDataProvider authenticationDataProvider) {
        this.authenticationDataProvider = authenticationDataProvider;
    }

    @Override
    public String execute(String token) {
       return authenticationDataProvider.validateToken(token);
    }
}
