package com.edemarcos.tcc.domain.authentication.usecasesimpl;

import com.edemarcos.tcc.domain.authentication.dataproviders.AuthenticationDataProvider;
import com.edemarcos.tcc.domain.authentication.usecases.GenerateTokenUseCase;
import com.edemarcos.tcc.domain.user.entities.User;

public class GenerateTokenUseCaseImpl implements GenerateTokenUseCase {

    private final AuthenticationDataProvider authenticationDataProvider;

    public GenerateTokenUseCaseImpl(AuthenticationDataProvider authenticationDataProvider) {
        this.authenticationDataProvider = authenticationDataProvider;
    }

    @Override
    public String execute(User user) {
        return authenticationDataProvider.generateToken(user);
    }
}
