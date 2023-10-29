package com.edemarcos.tcc.domain.authentication.usecasesimpl;

import com.edemarcos.tcc.domain.authentication.dataproviders.AuthenticationDataProvider;
import com.edemarcos.tcc.domain.authentication.usecases.LoadUserByUsernameUseCase;

public class LoadUserByUserNameUseCaseImpl implements LoadUserByUsernameUseCase {
    private final AuthenticationDataProvider authenticationDataProvider;

    public LoadUserByUserNameUseCaseImpl(AuthenticationDataProvider authenticationDataProvider) {
        this.authenticationDataProvider = authenticationDataProvider;
    }

    @Override
    public Object execute(String username) {
        return authenticationDataProvider.loadUserByUsername(username);
    }
}
